package com.felipearaujo.newsapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: Application): Context = app

}