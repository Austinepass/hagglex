package com.orgustine.hagglex.network

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Apollo {
    val log: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    val authHeader = "Bearer $accessTokenId"
    val authHeader = ""
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(log)
        .addInterceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder().method(original.method, original.body)
            builder.header("Authorization", authHeader)
            chain.proceed(builder.build())
        }
        .build()

    val apolloClient = ApolloClient.builder()
        .serverUrl("https://api-staging.hagglex.com/graphql")
        .build()
}