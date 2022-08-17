package com.accenture.acndemoproject.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.accenture.acndemoproject.R

class DetailsActivity : AppCompatActivity(), DetailsFragmenCallbackInterface {

    companion object{
        fun startActivity(context: Context, user: User) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("myUser", user)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val myUser = intent?.getParcelableExtra<User>("myUser")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(myUser))
                .commitNow()
        }
    }

    override fun onBackToPreviousActivity() {
        finish()
    }

}