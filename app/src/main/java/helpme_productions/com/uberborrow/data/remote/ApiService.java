package helpme_productions.com.uberborrow.data.remote;


import helpme_productions.com.uberborrow.model.CarInformation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/Vehicles.json")
    Call<CarInformation> carInformationCall();

    @POST("/Vehicles.json")
    Call<CarInformation> carInformationPost(@Body CarInformation carInformation);


}
