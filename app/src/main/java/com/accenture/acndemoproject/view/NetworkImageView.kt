package com.accenture.acndemoproject.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class NetworkImageView: AppCompatImageView {

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    )

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    )

    fun loadByUrl(url: String?){
        Glide.with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
    }

}