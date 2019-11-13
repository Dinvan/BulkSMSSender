package com.info.bulksmssender.api
import com.info.bulksmssender.model.APIResponse
import com.info.bulksmssender.model.ContactNumber
import com.info.bulksmssender.model.ProductResponse
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("user/promotion/contacts")
    fun getNumber(): Call<APIResponse<ContactNumber>>

    @GET("feed3/getCategoriesItem/1/{category_id}/0/{page}")
    fun getProducts(@Header("Authorization") token:String, @Path("category_id") categoryId:Long, @Path("page") page:Long): Call<ProductResponse>

   }
