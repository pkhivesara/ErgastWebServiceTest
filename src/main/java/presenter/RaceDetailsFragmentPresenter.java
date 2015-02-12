package presenter;


import com.formulaWebService.test.RaceDetailsFragment;
import com.formulaWebService.test.ServiceHelper;
import datasource.DataSource;
import datasource.DriverModel;
import datasource.PersistedDataSource;
import datasource.RaceDetailModel;

import java.util.List;

public class RaceDetailsFragmentPresenter {
    String input;
    RaceDetailsFragmentPresenterInterface raceDetailsFragmentPresenterInterface;
    ServiceHelper serviceHelper;
    DataSource dataSource = new PersistedDataSource();

    public RaceDetailsFragmentPresenter(RaceDetailsFragmentPresenterInterface raceDetailsFragmentPresenterInterface) {
        serviceHelper = new ServiceHelper(dataSource);
        this.raceDetailsFragmentPresenterInterface = raceDetailsFragmentPresenterInterface;
    }

    public void getRoundDetails(String input) {
        serviceHelper.getRoundDetails(input);
        this.input = input;
    }


    public void onEventMainThread(String message) {
        if (message.equals("race data saved")) {
            RaceDetailModel raceDetailModel = dataSource.getRaceDetails(input);
            raceDetailsFragmentPresenterInterface.setTextForRaceDetails(raceDetailModel);
        }
    }

    public interface RaceDetailsFragmentPresenterInterface {
        public void setTextForRaceDetails(RaceDetailModel raceDetailModel);
    }
}
