package com.accenture.acndemoproject.data.repository

import com.accenture.acndemoproject.data.mapper.UserMapper
import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.data.service.UserService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class UserRepository  @Inject constructor(val service: UserService, val mapper: UserMapper) : UserRepositoryInterface{

    override fun getUsers(): Observable<List<UserEntity>> {
        return service.getUsers().map { it.map { userEntity -> mapper.mapUserResponseEntityToUserEntity(userEntity) } }
    }

    override fun getUser(id: String): Single<UserEntity> {
        return service.getUsersSingle(id).map { mapper.mapUserResponseEntityToUserEntity(it) }
    }
}