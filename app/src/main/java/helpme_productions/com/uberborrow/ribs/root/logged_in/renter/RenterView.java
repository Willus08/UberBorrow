package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

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
}
