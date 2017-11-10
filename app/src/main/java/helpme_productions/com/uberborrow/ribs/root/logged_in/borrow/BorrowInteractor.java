package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import java.util.ArrayList;
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
    @Inject BorrowListener listener;
    FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Vehicles");;
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        final List<CarInformation> carInformations = new ArrayList<>();
        Call<CarInformation> carInformationCall = ApiProvider.carInformationCall();
        carInformationCall.enqueue(new retrofit2.Callback<CarInformation>() {
            @Override
            public void onResponse(Call<CarInformation> call, Response<CarInformation> response) {
                Log.d("please", response.body().toString());
                carInformations.add(response.body());
                //shortcutting this for now
                listener.beginBorrow(setBorrowinf(carInformations.get(0)));
            }

            @Override
            public void onFailure(Call<CarInformation> call, Throwable t) {

            }
        });


        super.didBecomeActive(savedInstanceState);
        //presenter.setupRecyclerView(carInformations);

        // TODO: Add attachment logic here (RxSubscriptions, etc.).
    }

    private CarInformation setBorrowinf(CarInformation information) {
        CarInformation borrowedInfo = information;
        borrowedInfo.setBorrower(current.getUid());
        return borrowedInfo;
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    public interface BorrowListener {
        void beginBorrow(CarInformation carInformation);
    }

    interface BorrowPresenter {
        // void setupRecyclerView(List<CarInformation> carInformationList);
    }
}
