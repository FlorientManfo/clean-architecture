package com.example.domain.di

import com.example.domain.services.NetworkService
import org.koin.dsl.module

val domainModule = module{
    single { NetworkService(get()) }
}