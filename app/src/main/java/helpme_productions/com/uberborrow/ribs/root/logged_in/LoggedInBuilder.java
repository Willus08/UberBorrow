package helpme_productions.com.uberborrow.ribs.root.logged_in;

import com.uber.rib.core.Builder;
import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.InteractorBaseComponent;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import dagger.BindsInstance;
import dagger.Provides;
import helpme_productions.com.uberborrow.ribs.root.logged_in.borrow.BorrowBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.maps.MapBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.maps.MapInteractor;
import helpme_productions.com.uberborrow.ribs.root.logged_in.renter.RenterBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.renter.RenterInteractor;
import helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle.ReturnVehicleBuilder;
import helpme_productions.com.uberborrow.ribs.root.RootView;

import static java.lang.annotation.RetentionPolicy.CLASS;

public class LoggedInBuilder extends Builder<LoggedInRouter, LoggedInBuilder.ParentComponent> {

    public LoggedInBuilder(ParentComponent dependency) {
        super(dependency);
    }

    /**
     * Builds a new {@link LoggedInRouter}.
     *
     * @return a new {@link LoggedInRouter}.
     */
    public LoggedInRouter build() {
        LoggedInInteractor interactor = new LoggedInInteractor();
        Component component = DaggerLoggedInBuilder_Component.builder()
                .parentComponent(getDependency())
                .interactor(interactor)
                .build();

        return component.loggedinRouter();
    }

    public interface ParentComponent {

        RootView rootView();
    }

    @dagger.Module
    public abstract static class Module {

        @LoggedInScope
        @Provides
        static EmptyPresenter presenter() {
            return new EmptyPresenter();
        }

        @LoggedInScope
        @Provides
        static MapInteractor.returnVehicalButtonListener returnVehicalButtonListener(LoggedInInteractor loggedInInteractor) {
            return loggedInInteractor.new ReturnVehicleButtonListener();
        }

        @LoggedInScope
        @Provides
        static MapInteractor.RentButtonListener retnButtonListener(LoggedInInteractor loggedInInteractor) {
            return loggedInInteractor.new RentButtonListener();
        }

        @LoggedInScope
        @Provides
        static RenterInteractor.RentingStartedListener rentingStartedListener(LoggedInInteractor loggedInInteractor) {
            return loggedInInteractor.new RentStartListener();
        }

        @LoggedInScope
        @Provides
        static MapInteractor.borrowButtonListener borrowButtonListener(LoggedInInteractor loggedInInteractor) {
            return loggedInInteractor.new BorrowButtonListener();
        }
        @LoggedInScope
        @Provides
        static LoggedInRouter router(Component component, LoggedInInteractor interactor,
                                     RootView rootView) {
            return new LoggedInRouter(
                    interactor,
                    component,
                    rootView,
                    new RenterBuilder(component),
                    new BorrowBuilder(component),
                    new MapBuilder(component));
        }

        // TODO: Create provider methods for dependencies created by this Rib. These methods should be static.
    }

    @LoggedInScope
    @dagger.Component(modules = Module.class, dependencies = ParentComponent.class)
    public interface Component extends InteractorBaseComponent<LoggedInInteractor>,
            RenterBuilder.ParentComponent,
            MapBuilder.ParentComponent,
            ReturnVehicleBuilder.ParentComponent,
            BorrowBuilder.ParentComponent,
            BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            Builder interactor(LoggedInInteractor interactor);
            Builder parentComponent(ParentComponent component);
            Component build();
        }

    }

    interface BuilderComponent {
        LoggedInRouter loggedinRouter();
    }

    @Scope
    @Retention(CLASS)
    @interface LoggedInScope { }


    @Qualifier
    @Retention(CLASS)
    @interface LoggedInInternal { }
}
