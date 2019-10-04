
package com.info.bulksmssender.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserErrorMessage {

    @SerializedName("user_message_fields")
    @Expose
    private List<UserMessageField> userMessageFields = null;
    @SerializedName("user_message")
    @Expose
    private String userMessage;

    public List<UserMessageField> getUserMessageFields() {
        return userMessageFields;
    }

    public void setUserMessageFields(List<UserMessageField> userMessageFields) {
        this.userMessageFields = userMessageFields;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
