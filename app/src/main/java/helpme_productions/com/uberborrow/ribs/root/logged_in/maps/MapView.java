package helpme_productions.com.uberborrow.ribs.root.logged_in.maps;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.jakewharton.rxbinding2.view.RxView;

import helpme_productions.com.uberborrow.R;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Top level view for {@link MapBuilder.MapScope}.
 */
class MapView extends FrameLayout implements MapInteractor.MapPresenter {

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public Observable<String> rentButtonPressed() {
        return RxView.clicks(findViewById(R.id.btnRent))
                .map(new Function<Object, String>() {

                    @Override
                    public String apply(Object o) throws Exception {
                    return "rent";
                    }
                });
    }
}
