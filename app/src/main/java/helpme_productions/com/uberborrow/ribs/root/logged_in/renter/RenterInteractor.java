package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import helpme_productions.com.uberborrow.model.CarInformation;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link RenterBuilder.RenterScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class RenterInteractor
        extends Interactor<RenterInteractor.RenterPresenter, RenterRouter> {

    @Inject RenterPresenter presenter;
    @Inject RentingStartedListener listener;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        presenter
                .GetcarInfo()
                .subscribe(new Consumer<CarInformation>() {
                    @Override
                    public void accept(CarInformation carinfo) throws Exception {

                        Log.d("yes", "accept: "+ carinfo);
                        listener.StartRent(carinfo);

                    }
                });
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
    interface RenterPresenter {
        Observable<CarInformation> GetcarInfo();
    }

    public interface RentingStartedListener {
        void StartRent(CarInformation carInformation);
    }


}
