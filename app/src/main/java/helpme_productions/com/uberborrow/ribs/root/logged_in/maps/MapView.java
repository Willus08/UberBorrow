package helpme_productions.com.uberborrow.ribs.root.logged_in.maps;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

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
}
