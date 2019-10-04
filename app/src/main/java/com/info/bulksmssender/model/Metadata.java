
package com.info.bulksmssender.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("http_status")
    @Expose
    private Integer httpStatus;
    @SerializedName("result_count")
    @Expose
    private Integer resultCount;
    @SerializedName("message")
    @Expose
    private String message;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
