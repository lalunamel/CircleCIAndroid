package net.codysehl.circleciandroid.network

import okhttp3.Interceptor
import okhttp3.Response

class ContentTypeJsonInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.removeHeader("Content-Type")
        requestBuilder.addHeader("Content-Type", "application/json")
        return chain.proceed(requestBuilder.build())
    }

}