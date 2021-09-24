package com.linlangli.walleter.net

import com.google.gson.GsonBuilder
import com.linlangli.pangtouyu.net.BaseNetApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    NetApi.INSTANCE.getApi(ApiService::class.java, ApiService.SERVER_URL)
}

class NetApi : BaseNetApi() {
    companion object {
        val INSTANCE: NetApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetApi()
        }
    }

    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.apply {
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
        return builder
    }

    override fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder.apply {
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
    }
}