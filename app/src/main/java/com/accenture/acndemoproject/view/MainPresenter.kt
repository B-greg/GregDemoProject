package com.accenture.acndemoproject.view

import android.util.Log
import com.accenture.acndemoproject.domain.UsersUseCase
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(val userUseCase: UsersUseCase){

    private var _view: MainViewInterface? = null


    private var counter = 0

    fun setView(view: MainViewInterface){
        _view = view
    }

    fun initView(){
        userUseCase.getListOfUsers(UsersSubscriber())
        //_view?.displayUsers(users)
    }

    fun onDestroy(){
        _view = null
    }

    fun onUserClick(){
        _view?.openDetailsActivity()
    }

    inner class UsersSubscriber: DisposableObserver<List<User>>() {
        override fun onNext(users: List<User>) {
            Log.d("UsersSubscriber", users.get(0).toString())
            _view?.displayUsers(users)
        }

        override fun onError(e: Throwable) {
            Log.e("UserSubscriber", e.message ?: "")
        }

        override fun onComplete() {
        }

    }

    inner class UserSubscriber: DisposableObserver<User>() {
        override fun onNext(user: User) {
            _view?.addUser(user)
        }

        override fun onError(e: Throwable) {
            Log.e("UserSubscriber", e.message ?: "")
        }

        override fun onComplete() {
        }

    }

    inner class UserSingleObservable: DisposableSingleObserver<List<User>>() {
        override fun onSuccess(t: List<User>) {
            _view?.displayUsers(t)
        }

        override fun onError(e: Throwable) {
            Log.e("UserSubscriber", e.message ?: "")
        }
    }

}