package com.wonder.data.di

import com.wonder.data.Database
import com.wonder.data.dao.ExampleDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule =  module{
    single { Database.getInstance(androidContext()) }
    single<ExampleDao> { get<Database>().exampleDao() }
}