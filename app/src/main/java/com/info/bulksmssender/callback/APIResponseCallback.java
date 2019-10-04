package com.info.bulksmssender.callback;
import androidx.appcompat.app.AppCompatActivity;
import com.info.bulksmssender.R;
import com.info.bulksmssender.model.APIResponse;
import com.info.bulksmssender.model.Metadata;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIResponseCallback {
    

    public static <T> void callAPI(Call<APIResponse<T>> call, final APICallback<T> responseCallback, final AppCompatActivity activity) {
     
        call.enqueue(new Callback<APIResponse<T>>() {
            @Override
            public void onResponse(Call<APIResponse<T>> call, Response<APIResponse<T>> response) {
     
                if (response == null) {
                    responseCallback.onErrorResponse(activity.getString(R.string.some_thing_went_wrong), 500,activity);
                    return;
                }
                APIResponse<T> apiResponse = response.body();
                if (apiResponse == null) {
                    responseCallback.onErrorResponse(activity.getString(R.string.some_thing_went_wrong),500, activity);
                    return;
                }

                Metadata metadata = apiResponse.getMetadata();
                if (metadata == null) {
                    responseCallback.onErrorResponse(apiResponse.getException(),500, activity);
                    return;
                }

                Integer httpStatus = metadata.getHttpStatus();
                if (httpStatus != null && httpStatus == 200) {
                    if (apiResponse.getData() == null || apiResponse.getData().size() != 0) {
                        if(!activity.isFinishing()){
                            responseCallback.onSuccessfulResponse(apiResponse.getData());
                        }
                    } else {
                        responseCallback.onErrorResponse(metadata.getMessage(),httpStatus, activity);
                    }
                }else  {
                    responseCallback.onErrorResponse(activity.getString(R.string.some_thing_went_wrong),httpStatus, activity);
                }
            }

            @Override
            public void onFailure(Call<APIResponse<T>> call, Throwable t) {
                responseCallback.onErrorResponse("Something went wrong,please try again later",500, activity);
            }
        });
    }
}
