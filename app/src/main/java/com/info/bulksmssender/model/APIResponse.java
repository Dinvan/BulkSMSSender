
package com.info.bulksmssender.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse<T> {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("data")
    @Expose
    private List<T> data = null;
    @SerializedName("error")
    @Expose
    private Error error;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("exception")
    @Expose
    private String exception;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
