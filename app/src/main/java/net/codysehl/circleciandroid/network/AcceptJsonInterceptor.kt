package net.codysehl.circleciandroid.network

import okhttp3.Interceptor
import okhttp3.Response

class AcceptJsonInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.removeHeader("Accept")
        requestBuilder.addHeader("Accept", "application/json")
        return chain.proceed(requestBuilder.build())
    }
}