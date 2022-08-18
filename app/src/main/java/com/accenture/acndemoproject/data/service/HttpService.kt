package com.accenture.acndemoproject.data.service

import android.os.SystemClock.sleep
import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.data.model.UserResponseEntity
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.delay
import java.util.*

class HttpService {

    fun getUsers(): Observable<List<UserResponseEntity>> {
        return Observable.just(List(20) { i -> UserResponseEntity("gregoire$i", "barret$i") })
    }

    fun getUsersSingle(): Single<List<UserResponseEntity>> {
        return Single.just(List(20) { i -> UserResponseEntity("gregoire$i", "barret$i") })
    }

    fun getUser(): Observable<UserResponseEntity> {
        return Observable.create { observable ->
            for (i in 0..20){
                sleep(1000)
                observable.onNext(UserResponseEntity("gregoire$i", "barret$i"))
            }
            observable.onComplete()
        }
    }
}