
package com.info.bulksmssender.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("user_error_message")
    @Expose
    private UserErrorMessage userErrorMessage;
    @SerializedName("system_error_message")
    @Expose
    private SystemErrorMessage systemErrorMessage;

    public UserErrorMessage getUserErrorMessage() {
        return userErrorMessage;
    }

    public void setUserErrorMessage(UserErrorMessage userErrorMessage) {
        this.userErrorMessage = userErrorMessage;
    }

    public SystemErrorMessage getSystemErrorMessage() {
        return systemErrorMessage;
    }

    public void setSystemErrorMessage(SystemErrorMessage systemErrorMessage) {
        this.systemErrorMessage = systemErrorMessage;
    }

}
