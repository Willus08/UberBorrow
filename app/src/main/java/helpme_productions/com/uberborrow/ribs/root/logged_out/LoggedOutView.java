package helpme_productions.com.uberborrow.ribs.root.logged_out;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import helpme_productions.com.uberborrow.R;
import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * Top level view for {@link LoggedOutBuilder.LoggedOutScope}.
 */
class LoggedOutView extends LinearLayout implements LoggedOutInteractor.LoggedOutPresenter {

    public LoggedOutView(Context context) {
        this(context, null);
    }

    public LoggedOutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoggedOutView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public Observable<String> loginUser() {

        return RxView.clicks(findViewById(R.id.login_button))
                .map(new Function<Object, String>() {

                    @Override
                    public String apply(Object o) throws Exception {
                        TextView email =  findViewById(R.id.etLoginEmail);
                        TextView password =  findViewById(R.id.etLogiPassword);
                        final String info = email.getText().toString() +" "+ password.getText().toString();
                        return info;
                    }
                });
    }
}
