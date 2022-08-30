package com.accenture.acndemoproject.domain.mapper

import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.view.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserEntityToUser(userEntity: UserEntity): User{
        return User(userEntity.name, userEntity.lastName)
    }
}