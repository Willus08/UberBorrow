package helpme_productions.com.uberborrow.ribs.root;

import com.uber.rib.core.ViewRouter;

import helpme_productions.com.uberborrow.ribs.root.logged_out.LoggedOutBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_out.LoggedOutRouter;

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class RootRouter extends
        ViewRouter<RootView, RootInteractor, RootBuilder.Component> {
        LoggedOutBuilder loggedOutBuilder;

    public RootRouter(RootView view, RootInteractor interactor, RootBuilder.Component component, LoggedOutBuilder loggedOutBuilder) {
        super(view, interactor, component);
        this.loggedOutBuilder = loggedOutBuilder;
    }

    public RootRouter(
            RootView view,
            RootInteractor interactor,
            RootBuilder.Component component) {
        super(view, interactor, component);
    }

    void attachLoggedOut(){

        LoggedOutRouter router = loggedOutBuilder.build(getView());
        attachChild(router);
       getView().addView(router.getView());
    }


}
