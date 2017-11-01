package mylocarson.coinmonitor.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mylocarson.coinmonitor.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 28/10/2017.
 */

public class Api_Service {
    private CryptoMonitorApi cryptoMonitorApi;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.ENDPOINT1)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public CryptoMonitorApi getCryptoMonitorApi() {
        this.cryptoMonitorApi = retrofit.create(CryptoMonitorApi.class);
        return cryptoMonitorApi;
    }
}
