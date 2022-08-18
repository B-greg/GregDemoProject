package com.accenture.acndemoproject.data.repository

import com.accenture.acndemoproject.data.mapper.UserMapper
import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.data.service.HttpService
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.core.Observable

class UserRepository(val service: HttpService = HttpService(), val mapper: UserMapper = UserMapper()) : UserRepositoryInterface{
    override fun getUsers(): Observable<List<UserEntity>> {
        return service.getUsers().map { it.map { userEntity -> mapper.mapUserResponseEntityToUserEntity(userEntity) } }
    }

    override fun getUser(): Observable<UserEntity> {
        return service.getUser().map { mapper.mapUserResponseEntityToUserEntity(it) }
    }
}