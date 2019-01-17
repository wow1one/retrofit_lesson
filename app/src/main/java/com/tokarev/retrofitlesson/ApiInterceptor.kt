package com.tokarev.retrofitlesson

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .addHeader("X-App-Platform", "Android/iOS")
            .addHeader("X-App-Version", "1.4.9")
            .build()

        return chain.proceed(request)
    }
}