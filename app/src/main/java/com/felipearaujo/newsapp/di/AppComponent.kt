package com.felipearaujo.newsapp.di

import android.app.Application
import com.felipearaujo.newsapp.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }

    fun inject(application: AppApplication)

}