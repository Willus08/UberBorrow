package helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle;

import android.support.annotation.NonNull;
import android.view.View;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link ReturnVehicleBuilder.ReturnVehicleScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class ReturnVehicleRouter extends
        ViewRouter<ReturnVehicleView, ReturnVehicleInteractor, ReturnVehicleBuilder.Component> {

    public ReturnVehicleRouter(
            ReturnVehicleView view,
            ReturnVehicleInteractor interactor,
            ReturnVehicleBuilder.Component component) {
        super(view, interactor, component);
    }
}
