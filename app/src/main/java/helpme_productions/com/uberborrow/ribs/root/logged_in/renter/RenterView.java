package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jakewharton.rxbinding2.view.RxView;

import helpme_productions.com.uberborrow.R;
import helpme_productions.com.uberborrow.model.CarInformation;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Top level view for {@link RenterBuilder.RenterScope}.
 */
class RenterView extends LinearLayout implements RenterInteractor.RenterPresenter {

    public RenterView(Context context) {
        this(context, null);
    }

    public RenterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RenterView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public Observable<CarInformation> GetcarInfo() {
        return RxView.clicks(findViewById(R.id.btnStartRent))
                .map(new Function<Object, CarInformation>() {

                    @Override
                    public CarInformation apply(Object o) throws Exception {
                        EditText carModel = findViewById(R.id.etCarModel);
                        EditText carMake = findViewById(R.id.etCarMake);
                        EditText carColor = findViewById(R.id.etCarColor);
                        EditText carYear = findViewById(R.id.etCarYear);
                        EditText startTime = findViewById(R.id.etAvailableStart);
                        EditText endTime = findViewById(R.id.etAvailableEnd);
                        FirebaseUser owner = FirebaseAuth.getInstance().getCurrentUser();
                        return new CarInformation(owner.getUid(),
                                "Available",
                                carMake.getText().toString(),
                                carModel.getText().toString(),
                                carColor.getText().toString(),
                                startTime.getText().toString(),
                                endTime.getText().toString(),
                                carYear.getText().toString(),
                                "0,0");
                    }
                });
    }
}
