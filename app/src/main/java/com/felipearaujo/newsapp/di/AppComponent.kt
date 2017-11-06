package com.felipearaujo.newsapp.di

import android.app.Application
import com.felipearaujo.data.di.NetworkModule
import com.felipearaujo.newsapp.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class, NetworkModule::class, AndroidInjectionModule::class, ActivityBuilder::class
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