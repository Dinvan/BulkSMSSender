
package com.info.bulksmssender.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemErrorMessage {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("error_code")
    @Expose
    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
