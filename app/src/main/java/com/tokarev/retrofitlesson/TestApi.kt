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

    @GET("retrofitlesson/getuser.php")
    fun getUserCallResponseBody(): Call<ResponseBody>

    @GET("retrofitlesson/getuser.php")
    fun getUserResponseBody(): ResponseBody

    @GET("retrofitlesson/getuser.php")
    fun getUserCall(): Call<User>

    @GET("retrofitlesson/getuser.php")
    fun getUser(): User

    @GET("retrofitlesson/{endpoint}.php")
    fun getUser(@Path("endpoint") endpoint: String): Call<User>

    @GET("retrofitlesson/getuser3.php")
    fun getUser(@Query("year") year: Int): Call<User>

    @POST("retrofitlesson/postbody.php")
    fun postBody(@Body body: RequestBody): Call<ResponseBody>

    @POST("retrofitlesson/postbody.php")
    fun postBody(@Body body: String): Call<String>

    @FormUrlEncoded
    @POST("retrofitlesson/postuser.php")
    fun postUser(@Field("year") year: Int): Call<User>

    @Headers(
        "X-App-Platform: Android",
        "X-App-Version: 1.8.0"
    )
    @POST("retrofitlesson/postheaders.php")
    fun postBodyWithHeaders(@Body body: String): Call<String>

    @POST("retrofitlesson/postheaders.php")
    fun postBodyWithHeaders(@Body body: String, @HeaderMap headers: Map<String, String>): Call<String>
}