package com.accenture.acndemoproject.data.model

import com.google.gson.annotations.SerializedName

data class UserResponseEntity(
     @SerializedName("name")
     val name: String? = null,
     val lastName: String? = null)