package com.orgustine.hagglex.network

import android.content.Context
import android.os.Looper
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.orgustine.hagglex.util.AuthStore
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Apollo {
    private var instance: ApolloClient? = null

    fun  apolloClient(context: Context): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        if (instance != null) {
            return instance!!
        }

        instance = ApolloClient.builder()
            .serverUrl("https://api-staging.hagglex.com/graphql")
            .okHttpClient(
                OkHttpClient.Builder()
                    .addInterceptor(AuthorizationInterceptor(context))
                    .build()
            )
            .build()
        return instance!!
    }

    private class AuthorizationInterceptor(val context: Context): Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val request = chain.request().newBuilder()
                .addHeader("Authorization", AuthStore.getToken(context) ?: "")
                .build()

            return chain.proceed(request)
        }
    }
}