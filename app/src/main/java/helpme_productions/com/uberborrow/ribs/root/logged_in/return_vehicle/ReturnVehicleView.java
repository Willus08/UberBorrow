package helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Top level view for {@link ReturnVehicleBuilder.ReturnVehicleScope}.
 */
class ReturnVehicleView extends View implements ReturnVehicleInteractor.ReturnVehiclePresenter {

    public ReturnVehicleView(Context context) {
        this(context, null);
    }

    public ReturnVehicleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReturnVehicleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
