package com.tokarev.retrofitlesson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.make_request_button
import kotlinx.android.synthetic.main.activity_main.request_data_edit_text
import kotlinx.android.synthetic.main.activity_main.response_text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private lateinit var requestDataEditText: EditText
    private lateinit var makeRequestButton: Button
    private lateinit var responseText: TextView

    private lateinit var testApi: TestApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestDataEditText = request_data_edit_text
        makeRequestButton = make_request_button
        makeRequestButton.setOnClickListener(::onMakeRequestButtonClicked)
        responseText = response_text

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/")
            .build()

        testApi = retrofit.create(TestApi::class.java)
    }

    private fun onMakeRequestButtonClicked(view: View) {
        testApi.getUserCallResponseBody().enqueue(
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    responseText.text = response.body()?.string()
                }
            }
        )

//        testApi.getUserCall().enqueue(
//            object : Callback<User> {
//                override fun onFailure(call: Call<User>, t: Throwable) {
//                }
//
//                override fun onResponse(call: Call<User>, response: Response<User>) {
//                    val name = response.body()?.name
//                    val age = response.body()?.age
//                    responseText.text = "Username: $name \nAge: $age"
//                }
//            }
//        )

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//
//                return@withContext testApi.getUserCall().execute()
//            }
//            val user = response.body()
//            val name = user?.name
//            val age = user?.age
//            responseText.text = "Username: $name \nAge: $age"
//        }

//        MainScope().launch {
//            val user = withContext(Dispatchers.IO) {
//
//                return@withContext testApi.getUser()
//            }
//            val name = user.name
//            val age = user.age
//            responseText.text = "Username: $name \nAge: $age"
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//
//                return@withContext testApi.getUser("getuser2").execute()
//            }
//            val user = response.body()
//            val name = user?.name
//            val age = user?.age
//            responseText.text = "Username: $name \nAge: $age"
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//
//                return@withContext testApi.getUser(1988).execute()
//            }
//            val user = response.body()
//            val name = user?.name
//            val age = user?.age
//            responseText.text = "Username: $name \nAge: $age"
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val mediaType = MediaType.get("text/plain")
//                val requestData = requestDataEditText.text.toString()
//                val requestBody = RequestBody.create(mediaType, requestData)
//
//                return@withContext testApi.postBody(requestBody).execute()
//            }
//            val responseMessage = response.body()?.string()
//            responseText.text = responseMessage
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val requestData: String = requestDataEditText.text.toString()
//
//                return@withContext testApi.postBody(requestData).execute()
//            }
//            val responseMessage = response.body()
//            responseText.text = responseMessage
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val requestData: Int = requestDataEditText.text.toString().toInt()
//
//                return@withContext testApi.postUser(requestData).execute()
//            }
//            val user = response.body()
//            val name = user?.name
//            val age = user?.age
//            responseText.text = "Username: $name \nAge: $age"
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val requestData: String = requestDataEditText.text.toString()
//
//                return@withContext testApi.postBodyWithHeaders(requestData).execute()
//            }
//            val responseMessage = response.body()
//            responseText.text = responseMessage
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val headers = mapOf(
//                    "X-App-Platform" to "iOS",
//                    "X-App-Version" to "2.0.0"
//                )
//                val requestData: String = requestDataEditText.text.toString()
//
//                return@withContext testApi.postBodyWithHeaders(requestData, headers).execute()
//            }
//            val responseMessage = response.body()
//            responseText.text = responseMessage
//        }

//        MainScope().launch {
//            val response = withContext(Dispatchers.IO) {
//                val requestData: String = requestDataEditText.text.toString()
//
//                return@withContext testApi.postBodyWithHeaders(requestData).execute()
//            }
//            val responseMessage = response.body()
//            responseText.text = responseMessage
//        }
    }
}
