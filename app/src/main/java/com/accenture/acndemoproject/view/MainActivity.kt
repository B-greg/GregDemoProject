package com.accenture.acndemoproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.accenture.acndemoproject.R

class MainActivity : AppCompatActivity() {


    private val onButtonClickLister = View.OnClickListener{
        DetailsActivity.startActivity(it.context, User("gregoire", "Barret"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val myText = findViewById<TextView>(R.id.textView)
        val myButton = findViewById<Button>(R.id.button)

        myButton.text = "click on me"

        myButton.setOnClickListener(onButtonClickLister)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}