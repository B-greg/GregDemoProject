package com.accenture.acndemoproject.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.accenture.acndemoproject.R


interface DetailsFragmenCallbackInterface{
    public fun onBackToPreviousActivity()
}

class DetailsFragment(val user: User?) : Fragment() {

    private lateinit var backButton: Button

    private  var callbackInterface: DetailsFragmenCallbackInterface? = null

    companion object {
        fun newInstance(user: User?) = DetailsFragment(user)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = view.findViewById<TextView>(R.id.message)
        backButton= view.findViewById(R.id.buttonback)
        message.text = user?.name


        backButton.setOnClickListener { callbackInterface?.onBackToPreviousActivity() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is DetailsFragmenCallbackInterface){
            callbackInterface = context
        } else {
            throw RuntimeException(requireContext().toString() + " must implement ExploreFragmentInterface")
        }
    }
}