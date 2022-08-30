package com.accenture.acndemoproject.data.service

import android.os.SystemClock.sleep
import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.data.model.UserResponseEntity
import com.accenture.acndemoproject.view.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.delay
import retrofit2.http.*
import java.util.*

interface UserService {

    @GET("users")
    fun getUsers(): Observable<List<UserResponseEntity>>

    @GET("users/:id")
    fun getUsersSingle(@Path("id" ) id: String): Single<UserResponseEntity>


    @POST("users")
    fun postUsersSingle(@Body user: UserResponseEntity): Single<List<UserResponseEntity>>

//    fun getUser(): Observable<UserResponseEntity> {
//        return Observable.create { observable ->
//            for (i in 0..20){
//                sleep(1000)
//                observable.onNext(UserResponseEntity("gregoire$i", "barret$i"))
//            }
//            observable.onComplete()
//        }
//    }
}