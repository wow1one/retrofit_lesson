package com.tokarev.retrofitlesson

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type


class CallAdapterFactory : CallAdapter.Factory() {

    override operator fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<Any, Any>? {

        if (returnType.toString().contains("retrofit2.Call")) {

            return null
        }

        return object : CallAdapter<Any, Any> {

            override fun responseType(): Type {

                return returnType
            }

            override fun adapt(call: Call<Any>): Any? {
                try {
                    return call.execute().body()
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}