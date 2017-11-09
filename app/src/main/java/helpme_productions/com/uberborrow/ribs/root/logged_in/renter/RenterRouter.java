package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link RenterBuilder.RenterScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class RenterRouter extends
        ViewRouter<RenterView, RenterInteractor, RenterBuilder.Component> {

    public RenterRouter(
            RenterView view,
            RenterInteractor interactor,
            RenterBuilder.Component component) {
        super(view, interactor, component);
    }
}
