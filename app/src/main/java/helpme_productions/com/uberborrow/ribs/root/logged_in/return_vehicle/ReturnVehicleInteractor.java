package helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

/**
 * Coordinates Business Logic for {@link ReturnVehicleBuilder.ReturnVehicleScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class ReturnVehicleInteractor
        extends Interactor<ReturnVehicleInteractor.ReturnVehiclePresenter, ReturnVehicleRouter> {

    @Inject ReturnVehiclePresenter presenter;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);

        // TODO: Add attachment logic here (RxSubscriptions, etc.).
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface ReturnVehiclePresenter { }
}
