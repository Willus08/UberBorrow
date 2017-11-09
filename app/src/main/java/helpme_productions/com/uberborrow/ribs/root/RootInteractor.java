package helpme_productions.com.uberborrow.ribs.root;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import helpme_productions.com.uberborrow.ribs.root.logged_out.LoggedOutInteractor;

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
    FirebaseUser currentUser;
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Log.d(TAG, "didBecomeActive()" + currentUser);
            getRouter().attachLoggedIn();
        }else{
            getRouter().attachLoggedOut();
        }
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }


    void signIn(final String email, final String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(executorService, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            currentUser = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            createAccount(email,password);
                        }

                        // ...
                    }
                });
    }

    void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(executorService, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            currentUser = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUser:failure", task.getException());
                        }

                        // ...
                    }
                });

    }
    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface RootPresenter { }

    class LoggedOutListener implements LoggedOutInteractor.Listener {
        @Override
        public void login(String userEmail, String userPassword) {
            signIn(userEmail,userPassword);
            if (currentUser!= null){
                getRouter().detachLoggedOut();
                getRouter().attachLoggedIn();
            }
        }
    }


}
