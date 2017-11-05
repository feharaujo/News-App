package com.felipearaujo.data.di

import android.app.Application
import android.content.Context
import com.felipearaujo.data.URL_BASE
import com.felipearaujo.data.remote.NewsApiService
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module()
class NetworkModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: Application): Context {
        return app
    }

    /*@Provides
    @Singleton
    fun providesGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRetrofit(factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(factory)
                .baseUrl(URL_BASE)
                .build()
    }*/

    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso {
        return Picasso.Builder(context)
                .loggingEnabled(true)
                .build()
    }

    /*@Provides
    @Singleton
    fun providesNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }*/


}