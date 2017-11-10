package helpme_productions.com.uberborrow.ribs.root.logged_in.maps;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link MapBuilder.MapScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class MapInteractor
        extends Interactor<MapInteractor.MapPresenter, MapRouter> {

    @Inject MapPresenter presenter;
    @Inject RentButtonListener rentButtonListener;
    @Inject BorrowButtonListener borrowButtonListener;
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);

        presenter
            .rentButtonPressed()
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String rent) throws Exception {
                rentButtonListener.setupRent();

            }
        });
        presenter.borrowButtonPressed()
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String rent) throws Exception {
                borrowButtonListener.setupBorrow();

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
    public interface RentButtonListener {
        void setupRent();
    }
    public interface BorrowButtonListener {
        void setupBorrow();
    }

    public interface returnVehicalButtonListener{}


    interface MapPresenter {
        Observable<String> rentButtonPressed();
        Observable<String> borrowButtonPressed();
    }
}
