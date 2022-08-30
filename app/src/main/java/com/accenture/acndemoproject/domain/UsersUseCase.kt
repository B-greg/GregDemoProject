package com.accenture.acndemoproject.domain

import com.accenture.acndemoproject.data.repository.UserRepository
import com.accenture.acndemoproject.data.repository.UserRepositoryInterface
import com.accenture.acndemoproject.domain.mapper.UserMapper
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersUseCase @Inject constructor(val repository: UserRepositoryInterface, val mapper: UserMapper) {

    fun getListOfUsers(observer: Observer<List<User>>) {
        repository.getUsers()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map{ it.map { userEntity -> mapper.mapUserEntityToUser(userEntity) }}
            .subscribe(observer)
    }


//    fun getUser(observer: Observer<User>) {
//        repository.getUser()
//            .subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .map{ userEntity -> mapper.mapUserEntityToUser(userEntity) }
//            .subscribe(observer)
//    }
}