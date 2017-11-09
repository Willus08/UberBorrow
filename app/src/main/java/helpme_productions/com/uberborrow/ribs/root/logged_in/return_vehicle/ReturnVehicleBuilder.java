package helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;
import java.lang.annotation.Retention;

import javax.inject.Scope;
import javax.inject.Qualifier;

import dagger.Provides;
import dagger.Binds;
import dagger.BindsInstance;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Builder for the {@link ReturnVehicleScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class ReturnVehicleBuilder
        extends ViewBuilder<ReturnVehicleView, ReturnVehicleRouter, ReturnVehicleBuilder.ParentComponent> {

    public ReturnVehicleBuilder(ParentComponent dependency) {
        super(dependency);
    }

    /**
     * Builds a new {@link ReturnVehicleRouter}.
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new {@link ReturnVehicleRouter}.
     */
    public ReturnVehicleRouter build(ViewGroup parentViewGroup) {
        ReturnVehicleView view = createView(parentViewGroup);
        ReturnVehicleInteractor interactor = new ReturnVehicleInteractor();
        Component component = DaggerReturnVehicleBuilder_Component.builder()
                .parentComponent(getDependency())
                .view(view)
                .interactor(interactor)
                .build();
        return component.returnvehicleRouter();
    }

    @Override
    protected ReturnVehicleView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
        // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
        // provided context from the parentViewGroup.
        return null;
    }

    public interface ParentComponent {
        // TODO: Define dependencies required from your parent interactor here.
    }

    @dagger.Module
    public abstract static class Module {

        @ReturnVehicleScope
        @Binds
        abstract ReturnVehicleInteractor.ReturnVehiclePresenter presenter(ReturnVehicleView view);

        @ReturnVehicleScope
        @Provides
        static ReturnVehicleRouter router(
            Component component,
            ReturnVehicleView view,
            ReturnVehicleInteractor interactor) {
            return new ReturnVehicleRouter(view, interactor, component);
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @ReturnVehicleScope
    @dagger.Component(modules = Module.class,
           dependencies = ParentComponent.class)
    interface Component extends InteractorBaseComponent<ReturnVehicleInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            Builder interactor(ReturnVehicleInteractor interactor);
            @BindsInstance
            Builder view(ReturnVehicleView view);
            Builder parentComponent(ParentComponent component);
            Component build();
        }
    }

    interface BuilderComponent  {
        ReturnVehicleRouter returnvehicleRouter();
    }

    @Scope
    @Retention(CLASS)
    @interface ReturnVehicleScope { }

    @Qualifier
    @Retention(CLASS)
    @interface ReturnVehicleInternal { }
}
