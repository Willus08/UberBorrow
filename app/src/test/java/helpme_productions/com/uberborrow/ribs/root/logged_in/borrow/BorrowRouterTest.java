package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.core.RouterHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BorrowRouterTest extends RibTestBasePlaceholder {

    @Mock BorrowBuilder.Component component;
    @Mock BorrowInteractor interactor;
    @Mock BorrowView view;

    private BorrowRouter router;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        router = new BorrowRouter(view, interactor, component);
    }

    /**
     * TODO: Delete this example and add real tests.
     */
    @Test
    public void anExampleTest_withSomeConditions_shouldPass() {
        // Use RouterHelper to drive your router's lifecycle.
        RouterHelper.attach(router);
        RouterHelper.detach(router);

        throw new RuntimeException("Remove this test and add real tests.");
    }

}
