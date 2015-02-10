package presenter;


import com.formulaWebService.test.RaceDetailsFragment;
import com.formulaWebService.test.ServiceHelper;
import datasource.DataSource;
import datasource.DriverModel;
import datasource.PersistedDataSource;

import java.util.List;

public class RaceDetailsFragmentPresenter {
    RaceDetailsFragmentPresenterInterface raceDetailsFragmentPresenterInterface;
    ServiceHelper serviceHelper;
    DataSource dataSource = new PersistedDataSource();
    public RaceDetailsFragmentPresenter(RaceDetailsFragmentPresenterInterface raceDetailsFragmentPresenterInterface) {
        serviceHelper = new ServiceHelper(dataSource);
        this.raceDetailsFragmentPresenterInterface = raceDetailsFragmentPresenterInterface;
    }

    public interface RaceDetailsFragmentPresenterInterface {

    }
}
