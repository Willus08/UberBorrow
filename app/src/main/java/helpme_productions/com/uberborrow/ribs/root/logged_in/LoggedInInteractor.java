package helpme_productions.com.uberborrow.ribs.root.logged_in;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

/**
 * Coordinates Business Logic for {@link LoggedInBuilder.LoggedInScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedInInteractor extends Interactor<EmptyPresenter, LoggedInRouter> {

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        getRouter().attachMap();
        // TODO: Add attachment logic here (RxSubscriptions, etc.).
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }

}
