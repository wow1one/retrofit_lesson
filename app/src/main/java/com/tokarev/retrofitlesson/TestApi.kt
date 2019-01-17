package com.tokarev.retrofitlesson

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TestApi {

    @GET("retrofitLesson/getUser")
    fun getUserCallResponseBody(): Call<ResponseBody>

    @GET("retrofitLesson/getUser")
    fun getUserResponseBody(): ResponseBody

    @GET("retrofitLesson/getUser")
    fun getUserCall(): Call<User>

    @GET("retrofitLesson/getUser")
    fun getUser(): User

    @GET("retrofitLesson/{endpoint}")
    fun getUser(@Path(value = "endpoint", encoded = false) endpoint: String): Call<User>

    @GET("retrofitLesson/getUserCalculatedAge")
    fun getUserCalculatedAge(@Query("year") year: Int): Call<User>

    @POST("retrofitLesson/postBody")
    fun postBody(@Body body: RequestBody): Call<ResponseBody>

    @POST("retrofitLesson/postBody")
    fun postBody(@Body body: String): Call<String>

    @FormUrlEncoded
    @POST("retrofitLesson/postUserCalculatedAge")
    fun postUserCalculatedAge(@Field("year") year: Int): Call<User>

//    @Headers(
//        "X-App-Platform: Android",
//        "X-App-Version: 1.8.0"
//    )
    @POST("retrofitLesson/postHeaders")
    fun postBodyWithHeaders(@Body body: String): Call<String>

    @POST("retrofitLesson/postHeaders")
    fun postBodyWithHeaders(@Body body: String, @HeaderMap headers: Map<String, String>): Call<String>
}