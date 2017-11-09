package helpme_productions.com.uberborrow.ribs.root;

import android.util.Log;

import com.uber.rib.core.ViewRouter;

import helpme_productions.com.uberborrow.ribs.root.logged_in.LoggedInBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_out.LoggedOutBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_out.LoggedOutRouter;

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class RootRouter extends
        ViewRouter<RootView, RootInteractor, RootBuilder.Component> {
        private LoggedOutBuilder loggedOutBuilder;
        private LoggedInBuilder loggedInBuilder;

        private LoggedOutRouter loggedOutRouter;

    public RootRouter(RootView view, RootInteractor interactor, RootBuilder.Component component, LoggedOutBuilder loggedOutBuilder, LoggedInBuilder loggedInBuilder) {
        super(view, interactor, component);
        this.loggedOutBuilder = loggedOutBuilder;
        this.loggedInBuilder = loggedInBuilder;
    }

    public RootRouter(
            RootView view,
            RootInteractor interactor,
            RootBuilder.Component component) {
        super(view, interactor, component);
    }

    void attachLoggedOut(){
       loggedOutRouter = loggedOutBuilder.build(getView());
        attachChild(loggedOutRouter);
       getView().addView(loggedOutRouter.getView());
    }


    public void attachLoggedIn() {
        Log.d("awesome", "attachLoggedIn: ");
        attachChild(loggedInBuilder.build());
    }

    public void detachLoggedOut() {
        Log.d("awesome", "detachLoggedOut: ");
        if (loggedOutRouter != null) {
            detachChild(loggedOutRouter);
            getView().removeView(loggedOutRouter.getView());
            loggedOutRouter = null;
        }
    }

}
