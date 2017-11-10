package helpme_productions.com.uberborrow.ribs.root.logged_in.maps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Provides;
import helpme_productions.com.uberborrow.R;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Builder for the {@link MapScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class MapBuilder
        extends ViewBuilder<MapView, MapRouter, MapBuilder.ParentComponent> {

    public MapBuilder(ParentComponent dependency) {
        super(dependency);
    }

    /**
     * Builds a new {@link MapRouter}.
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new {@link MapRouter}.
     */
    public MapRouter build(ViewGroup parentViewGroup) {
        MapView view = createView(parentViewGroup);
        MapInteractor interactor = new MapInteractor();
        Component component = DaggerMapBuilder_Component.builder()
                .parentComponent(getDependency())
                .view(view)
                .interactor(interactor)
                .build();
        return component.mapRouter();
    }

    @Override
    protected MapView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
        // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
        // provided context from the parentViewGroup.
        return (MapView) inflater.inflate(R.layout.maps_rib, parentViewGroup, false);
    }

    public interface ParentComponent {
       MapInteractor.RentButtonListener rentButtonListener();
    }

    @dagger.Module
    public abstract static class Module {

        @MapScope
        @Binds
        abstract MapInteractor.MapPresenter presenter(MapView view);

        @MapScope
        @Provides
        static MapRouter router(
            Component component,
            MapView view,
            MapInteractor interactor) {
            return new MapRouter(view, interactor, component);
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @MapScope
    @dagger.Component(modules = Module.class,
           dependencies = ParentComponent.class)
    interface Component extends InteractorBaseComponent<MapInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            Builder interactor(MapInteractor interactor);
            @BindsInstance
            Builder view(MapView view);
            Builder parentComponent(ParentComponent component);
            Component build();
        }
    }

    interface BuilderComponent  {
        MapRouter mapRouter();
    }

    @Scope
    @Retention(CLASS)
    @interface MapScope { }

    @Qualifier
    @Retention(CLASS)
    @interface MapInternal { }
}
