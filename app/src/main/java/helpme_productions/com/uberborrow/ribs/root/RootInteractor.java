package helpme_productions.com.uberborrow.ribs.root;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

/**
 * Coordinates Business Logic for {@link RootBuilder.RootScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class RootInteractor
        extends Interactor<RootInteractor.RootPresenter, RootRouter> {

    @Inject RootPresenter presenter;

    private FirebaseAuth mAuth;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Log.d(TAG, "didBecomeActive()" + currentUser);
        }else{
            getRouter().attachLoggedOut();
        }
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface RootPresenter { }
}
