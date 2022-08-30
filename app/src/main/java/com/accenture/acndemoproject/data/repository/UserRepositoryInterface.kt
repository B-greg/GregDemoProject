package com.accenture.acndemoproject.data.repository

import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface UserRepositoryInterface {
    fun getUsers(): Observable<List<UserEntity>>
    fun getUser(id: String): Single<UserEntity>

}
