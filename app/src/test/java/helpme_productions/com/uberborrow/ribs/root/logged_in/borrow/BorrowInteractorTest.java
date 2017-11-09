package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.core.InteractorHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BorrowInteractorTest extends RibTestBasePlaceholder {

    @Mock BorrowInteractor.BorrowPresenter presenter;
    @Mock BorrowRouter router;

    private BorrowInteractor interactor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        interactor = TestBorrowInteractor.create(presenter);
    }

    /**
     * TODO: Delete this example and add real tests.
     */
    @Test
    public void anExampleTest_withSomeConditions_shouldPass() {
        // Use InteractorHelper to drive your interactor's lifecycle.
        InteractorHelper.attach(interactor, presenter, router, null);
        InteractorHelper.detach(interactor);

        throw new RuntimeException("Remove this test and add real tests.");
    }

}
