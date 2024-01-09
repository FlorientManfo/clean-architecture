package com.wonder.domain.di

import com.wonder.domain.services.NetworkService
import org.koin.dsl.module

val domainModule = module{
    single { NetworkService(get()) }
}