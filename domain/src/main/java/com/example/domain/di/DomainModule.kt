package com.example.domain.di

import com.example.domain.utils.NetworkService
import org.koin.dsl.module

val domainModule = module{
    single { NetworkService(get()) }
}