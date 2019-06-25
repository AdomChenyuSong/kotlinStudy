package conn

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpLoggingInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request=chain.request()
        var t1=System.nanoTime()
        Log.e(
            "HttpLoggingInterceptor", String.format(
                "发送请求 %s on %s%n%s",
                request.url(), chain.connection(), request.headers()
            )
        )
        var response=chain.proceed(request)
        var t2=System.nanoTime()
        val responseBody=response.peekBody(1024*1024)
        Log.e(
            "HttpLoggingInterceptor", String.format(
                "接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                response.request().url(),
                responseBody.string(),
                (t2 - t1) / 1e6,
                response.headers()
            )
        )

        return response



    }
}