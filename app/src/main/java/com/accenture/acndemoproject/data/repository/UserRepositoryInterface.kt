package com.accenture.acndemoproject.data.repository

import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.core.Observable

interface UserRepositoryInterface {
    fun getUsers(): Observable<List<UserEntity>>
    fun getUser(): Observable<UserEntity>

}
