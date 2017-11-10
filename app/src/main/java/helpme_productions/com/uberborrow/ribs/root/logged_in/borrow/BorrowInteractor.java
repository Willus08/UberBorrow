package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import java.util.List;

import javax.inject.Inject;

import helpme_productions.com.uberborrow.data.remote.ApiProvider;
import helpme_productions.com.uberborrow.model.CarInformation;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Coordinates Business Logic for {@link BorrowBuilder.BorrowScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class BorrowInteractor
        extends Interactor<BorrowInteractor.BorrowPresenter, BorrowRouter> {

    @Inject BorrowPresenter presenter;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {

        retrofit2.Call<List<CarInformation>> infoCall = ApiProvider.carInformationCall();
        infoCall.enqueue(new retrofit2.Callback<List<CarInformation>>() {
            @Override
            public void onResponse(Call<List<CarInformation>> call, Response<List<CarInformation>> response) {
                presenter.setupRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<CarInformation>> call, Throwable t) {

            }
        });

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
    public interface borrowListener{
        void beginBorrow(CarInformation carInformation);
    }

    interface BorrowPresenter {
        void setupRecyclerView(List<CarInformation> carInformationList);
    }
}
