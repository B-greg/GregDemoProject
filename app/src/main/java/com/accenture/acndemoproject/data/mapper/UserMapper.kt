package com.accenture.acndemoproject.data.mapper

import com.accenture.acndemoproject.data.model.UserEntity
import com.accenture.acndemoproject.data.model.UserResponseEntity
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserResponseEntityToUserEntity(userEntity: UserResponseEntity): UserEntity{
        return UserEntity(userEntity.name, userEntity.lastName)
    }
}