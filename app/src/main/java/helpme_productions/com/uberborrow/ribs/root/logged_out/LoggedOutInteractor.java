package helpme_productions.com.uberborrow.ribs.root.logged_out;

import android.support.annotation.Nullable;
import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link LoggedOutBuilder.LoggedOutScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedOutInteractor
        extends Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter> {

    @Inject LoggedOutPresenter presenter;
    @Inject Listener listener;
    private String userPassword;
    private String userEmail;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        presenter
                .loginUser()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String user) throws Exception {
                        userPassword = user.substring(user.indexOf(".com")+5);
                        userEmail = user.substring(0,user.indexOf(".com")+4);
                        if(!userEmail.isEmpty() && !userPassword.isEmpty()){
                            listener.login(userEmail,userPassword);
                        }
                        Log.d("moo", "didBecomeActive: " + userEmail +": "+ userPassword);
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
    interface LoggedOutPresenter {
        Observable <String>loginUser();
    }

    public interface Listener {
        void login(String useEmail, String userPassword);
    }


}
