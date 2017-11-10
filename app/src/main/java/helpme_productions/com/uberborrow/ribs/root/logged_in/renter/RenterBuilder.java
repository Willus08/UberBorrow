package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

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
 * Builder for the {@link RenterScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class RenterBuilder
        extends ViewBuilder<RenterView, RenterRouter, RenterBuilder.ParentComponent> {

    public RenterBuilder(ParentComponent dependency) {
        super(dependency);
    }

    /**
     * Builds a new {@link RenterRouter}.
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new {@link RenterRouter}.
     */
    public RenterRouter build(ViewGroup parentViewGroup) {
        RenterView view = createView(parentViewGroup);
        RenterInteractor interactor = new RenterInteractor();
        Component component = DaggerRenterBuilder_Component.builder()
                .parentComponent(getDependency())
                .view(view)
                .interactor(interactor)
                .build();
        return component.renterRouter();
    }

    @Override
    protected RenterView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
        // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
        // provided context from the parentViewGroup.
        return (RenterView) inflater.inflate(R.layout.renter_rib, parentViewGroup, false);
    }

    public interface ParentComponent {
        RenterInteractor.RentingStartedListener rentStartedListener();
    }

    @dagger.Module
    public abstract static class Module {

        @RenterScope
        @Binds
        abstract RenterInteractor.RenterPresenter presenter(RenterView view);

        @RenterScope
        @Provides
        static RenterRouter router(
            Component component,
            RenterView view,
            RenterInteractor interactor) {
            return new RenterRouter(view, interactor, component);
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @RenterScope
    @dagger.Component(modules = Module.class,
           dependencies = ParentComponent.class)
    interface Component extends InteractorBaseComponent<RenterInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            Builder interactor(RenterInteractor interactor);
            @BindsInstance
            Builder view(RenterView view);
            Builder parentComponent(ParentComponent component);
            Component build();
        }
    }

    interface BuilderComponent  {
        RenterRouter renterRouter();
    }

    @Scope
    @Retention(CLASS)
    @interface RenterScope { }

    @Qualifier
    @Retention(CLASS)
    @interface RenterInternal { }
}
