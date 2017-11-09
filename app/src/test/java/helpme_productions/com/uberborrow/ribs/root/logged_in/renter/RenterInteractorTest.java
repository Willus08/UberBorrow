package helpme_productions.com.uberborrow.ribs.root.logged_in.renter;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.core.InteractorHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RenterInteractorTest extends RibTestBasePlaceholder {

    @Mock RenterInteractor.RenterPresenter presenter;
    @Mock RenterRouter router;

    private RenterInteractor interactor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        interactor = TestRenterInteractor.create(presenter);
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
