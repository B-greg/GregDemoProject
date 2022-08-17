package com.accenture.acndemoproject.view

class MainPresenter {

    private var _view: MainViewInterface? = null

    private var counter = 0

    fun setView(view: MainViewInterface){
        _view = view
    }

    fun initView(){
        val users = Array(20){ i ->  User("gregoire$i", "barret$i")}
        _view?.displayUsers(users.asList())
    }

    fun onDestroy(){
        _view = null
    }

    fun onUserClick(){
        _view?.openDetailsActivity()
    }

}