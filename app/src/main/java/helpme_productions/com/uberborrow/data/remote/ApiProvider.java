package helpme_productions.com.uberborrow.data.remote;


import java.util.List;

import helpme_productions.com.uberborrow.model.CarInformation;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static final String BASE_URL = "https://uberborrow.firebaseio.com/";

    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Call<List<CarInformation>> carInformationCall(){
        Retrofit retrofit = create();
        ApiService services = retrofit.create(ApiService.class);
        return services.carInformationCall();
    }
}
