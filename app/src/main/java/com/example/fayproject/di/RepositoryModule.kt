package com.example.fayproject.di

import com.example.fayproject.repository.AppointmentsRepository
import com.example.fayproject.repository.AppointmentsRepositoryImpl
import com.example.fayproject.repository.LoginRepository
import com.example.fayproject.repository.LoginRepositoryImpl
import com.example.fayproject.repository.TokenRepository
import com.example.fayproject.repository.TokenRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    // TODO: Token Repo being a singleton here isn't ideal
    //  should store token in data store (after encryption)
    //  then can remove this Singleton
    @Binds
    @Singleton
    fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository

    @Binds
    fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    fun bindAppointmentsRepository(appointmentsRepositoryImpl: AppointmentsRepositoryImpl): AppointmentsRepository
}
