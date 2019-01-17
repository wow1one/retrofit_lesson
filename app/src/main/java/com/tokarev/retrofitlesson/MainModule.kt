package com.tokarev.retrofitlesson

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val LOGGING_INTERCEPTOR = "logging_interceptor"
private const val API_INTERCEPTOR = "api_interceptor"
private const val USER_API = "user_api"

val mainModule = module {
    single(LOGGING_INTERCEPTOR) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        } as Interceptor
    }
    single(API_INTERCEPTOR) {
        ApiInterceptor() as Interceptor
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get(LOGGING_INTERCEPTOR))
            .addInterceptor(get(API_INTERCEPTOR))
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bff-vd-krisha-ak.kolesa-team.org/")
            .client(get())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        retrofit.create(TestApi::class.java) as TestApi
    }
}