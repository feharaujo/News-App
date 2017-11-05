package com.felipearaujo.newsapp.di

import com.felipearaujo.data.di.NetworkModule
import dagger.Module

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module(includes = arrayOf(NetworkModule::class))
class AppModule