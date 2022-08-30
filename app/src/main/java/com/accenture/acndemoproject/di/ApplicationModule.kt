package com.accenture.acndemoapplication.di

import android.app.Application
import android.content.Context
import com.accenture.acndemoproject.data.mapper.UserMapper
import com.accenture.acndemoproject.data.repository.UserRepository
import com.accenture.acndemoproject.data.repository.UserRepositoryInterface
import com.accenture.acndemoproject.data.service.UserService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }


    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideUserRepository(service: UserService, mapper: UserMapper): UserRepositoryInterface = UserRepository(service, mapper)
}