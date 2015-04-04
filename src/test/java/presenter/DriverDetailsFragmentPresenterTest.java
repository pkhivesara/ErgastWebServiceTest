package presenter;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DriverDetailsFragmentPresenterTest {
    DriverDetailsFragmentPresenter detailsFragmentPresenter;
    DriverDetailsFragmentPresenter.FragmentHelperInterface fragmentHelperInterface;


    @Before
    public void setUp() {
        detailsFragmentPresenter = new DriverDetailsFragmentPresenter(fragmentHelperInterface);
    }

    @Test
    public void test_whether_presenter_is_initialized() {
        assertNotNull(detailsFragmentPresenter);
    }
}
