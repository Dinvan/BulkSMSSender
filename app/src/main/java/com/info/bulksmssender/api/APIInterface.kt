package com.info.bulksmssender.api
import com.info.bulksmssender.model.APIResponse
import com.info.bulksmssender.model.ContactNumber
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("user/promotion/contacts")
    fun getNumber(): Call<APIResponse<ContactNumber>>

   }
