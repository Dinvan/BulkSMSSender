package com.info.bulksmssender.model


import com.google.gson.annotations.SerializedName

data class ContactNumber(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("mobile_number")
    val mobileNumber: Long,
    @SerializedName("send")
    val send: Int,
    @SerializedName("shop_name")
    val shopName: String
)