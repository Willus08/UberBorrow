package helpme_productions.com.uberborrow.ribs.root.logged_in;

import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import helpme_productions.com.uberborrow.model.CarInformation;
import helpme_productions.com.uberborrow.ribs.root.logged_in.maps.MapInteractor;
import helpme_productions.com.uberborrow.ribs.root.logged_in.renter.RenterInteractor;

/**
 * Coordinates Business Logic for {@link LoggedInBuilder.LoggedInScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedInInteractor extends Interactor<EmptyPresenter, LoggedInRouter> {
    private FirebaseAuth mAuth;
    private FirebaseDatabase mData;
    DatabaseReference mRef;
    FirebaseUser currentUser;
   private boolean buttonpressed = false;
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance();
        mRef = mData.getReference("Vehicles");

        currentUser = mAuth.getCurrentUser();
        mRef = mRef.child("Owener" + currentUser.getUid());

        if (!buttonpressed){
            getRouter().attachMap();
        }
        // TODO: Add attachment logic here (RxSubscriptions, etc.).
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }

    class RentButtonListener implements MapInteractor.RentButtonListener {

        @Override
        public void setupRent() {
            buttonpressed = true;
            getRouter().detachMap();
            getRouter().attachRenter();
        }
    }

    class BorrowButtonListener implements MapInteractor.borrowButtonListener{

    }

    class ReturnVehicleButtonListener implements MapInteractor.returnVehicalButtonListener{

    }

    class RentStartListener implements RenterInteractor.RentingStartedListener{

        @Override
        public void StartRent(CarInformation carInformation) {
            mRef.setValue(carInformation);
            buttonpressed = false;
            getRouter().detachRenter();
            getRouter().attachMap();
        }
    }

}
