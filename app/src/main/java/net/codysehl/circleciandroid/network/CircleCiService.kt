package net.codysehl.circleciandroid.network

import net.codysehl.circleciandroid.models.SignedInUser
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface CircleCiService {
    @GET("me")
    suspend fun me(@Query("circle-token") apiKey: String): SignedInUser

    companion object {
        fun create(): CircleCiService {
            val client = OkHttpClient.Builder()
                .addInterceptor(LoggingBodyInterceptor())
                .addInterceptor(AcceptJsonInterceptor())
                .addInterceptor(ContentTypeJsonInterceptor())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://circleci.com/api/v1.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(CircleCiService::class.java)
        }
    }
}