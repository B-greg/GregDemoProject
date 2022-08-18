package com.accenture.acndemoproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accenture.acndemoproject.R

class MainActivity : AppCompatActivity(), MainViewInterface, UserAdapterInterface {


    private lateinit var presenter: MainPresenter

    private lateinit var usersRecycleView: RecyclerView

    private var userAdapter: UserAdapter = UserAdapter(arrayListOf(), this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()

        usersRecycleView = findViewById(R.id.users_recycleview)
        usersRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        usersRecycleView.adapter = userAdapter

        presenter.setView(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.initView()

    }

    override fun onResume() {
        super.onResume()
    }


    override fun openDetailsActivity() {
        DetailsActivity.startActivity(this, User("gregoire", "Barret"))
    }

    override fun onUserClick(user: User) {
        presenter.onUserClick()
    }

    override fun displayUsers(users: List<User>) {
        userAdapter.setUsersList(users)
        userAdapter.addUser(User("test", "test"))
    }

    override fun addUser(user: User) {
        userAdapter.addUser(user)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


}