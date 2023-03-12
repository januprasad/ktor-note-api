package com.example.data.di.modules

import com.example.data.UserRepositoryImpl
import com.example.data.source.DatabaseFactory
import com.example.data.source.userDao.UserDAO
import com.example.data.source.userDao.UserDAOImpl
import com.example.domain.UserRepository
import com.example.domain.usecases.LoginUseCase
import com.example.domain.usecases.RegisterUseCase
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module

val mainModule = module {
    single {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./build/db"
        Database.connect(jdbcURL, driverClassName)
    }
    single {
        DatabaseFactory(get())
    }
    single<UserDAO> {
        UserDAOImpl()
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }

    single {
        RegisterUseCase(get())
    }
    single {
        LoginUseCase(get())
    }
}