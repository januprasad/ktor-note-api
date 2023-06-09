package com.example.data

import com.example.data.source.userDao.UserDAO
import com.example.domain.UserRepository
import com.example.domain.models.UserModel
import java.util.*

class UserRepositoryImpl constructor(private var userDAO: UserDAO) : UserRepository {
    override suspend fun addUser(email: String, password: String, name: String): UserModel? {
        return userDAO.insetUser(
            userEmail = email,
            userName = name,
            userPassword = password
        )?.let(::resultRowToUser)
    }

    override suspend fun getUserByEmail(email: String): UserModel? {
        return userDAO.getUserByEmail(email = email)?.let(::resultRowToUser)
    }


    override suspend fun isEmailExist(email: String): Boolean {
        return userDAO.getUserByEmail(email = email) != null
    }
}