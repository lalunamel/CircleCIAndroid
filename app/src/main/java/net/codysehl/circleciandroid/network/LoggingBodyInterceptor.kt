package net.codysehl.circleciandroid.network

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

fun LoggingBodyInterceptor(): Interceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}