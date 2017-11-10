package helpme_productions.com.uberborrow.data.remote;


import java.util.List;

import helpme_productions.com.uberborrow.model.CarInformation;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("")
    Call<List<CarInformation>> carInformationCall();

}
