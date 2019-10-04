package com.info.bulksmssender.callback;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public interface APICallback<T> {
    void onSuccessfulResponse(List<T> responseBody);
    default void onErrorResponse(String errorMessage, int errorCode, AppCompatActivity activity)
    {

    }

}
