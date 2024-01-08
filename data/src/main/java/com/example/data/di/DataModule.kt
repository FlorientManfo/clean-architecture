package com.example.data.di

import com.example.data.Database
import com.example.data.dao.ExampleDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule =  module{
    single { Database.getInstance(androidContext()) }
    single<ExampleDao> { get<Database>().exampleDao() }
}