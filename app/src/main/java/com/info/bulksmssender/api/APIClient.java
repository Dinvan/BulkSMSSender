package com.info.bulksmssender.api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;

public class APIClient {

    public static String BASE_URL_DEV  = "http://35.1199.11.1994:8080/";
    public static APIInterface getAPIInterface() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_DEV)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        return apiInterface;
    }

}
