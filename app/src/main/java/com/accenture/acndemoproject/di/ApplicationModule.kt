package com.accenture.acndemoapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApplicationModule {

//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//
//        val okHttpClient = OkHttpClient.Builder().apply {
//            readTimeout(60, TimeUnit.SECONDS)
//            connectTimeout(60, TimeUnit.SECONDS)
//            addInterceptor(
//                Interceptor { chain ->
//                    val builder = chain.request().newBuilder()
//                    builder.header(
//                        "Authorization",
//                        "563492ad6f9170000100000120968e9692d145ab95baafc33307a8fc"
//                    )
//                    return@Interceptor chain.proceed(builder.build())
//                }
//            )
//        }
//
//        return Retrofit.Builder()
////            .baseUrl("https://us-central1-acndemoandroid.cloudfunctions.net/widgets/")
//            .baseUrl("https://api.pexels.com/v1/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .client(okHttpClient.build())
//
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideFlowerService(retrofit: Retrofit): FlowerService {
//        return retrofit.create(FlowerService::class.java)
//    }
//

    @Provides
    fun provideContext(application: Application): Context = application
}