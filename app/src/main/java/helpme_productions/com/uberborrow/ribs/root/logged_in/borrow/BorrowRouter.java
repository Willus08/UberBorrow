package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.support.annotation.NonNull;
import android.view.View;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link BorrowBuilder.BorrowScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class BorrowRouter extends
        ViewRouter<BorrowView, BorrowInteractor, BorrowBuilder.Component> {

    public BorrowRouter(
            BorrowView view,
            BorrowInteractor interactor,
            BorrowBuilder.Component component) {
        super(view, interactor, component);
    }
}
