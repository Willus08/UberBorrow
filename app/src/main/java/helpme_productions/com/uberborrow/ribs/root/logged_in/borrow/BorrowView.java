package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Top level view for {@link BorrowBuilder.BorrowScope}.
 */
class BorrowView extends View implements BorrowInteractor.BorrowPresenter {

    public BorrowView(Context context) {
        this(context, null);
    }

    public BorrowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorrowView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
