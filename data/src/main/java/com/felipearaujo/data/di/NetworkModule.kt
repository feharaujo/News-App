package com.felipearaujo.data.di

import android.content.Context
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.data.NewsRepositoryImp
import com.felipearaujo.data.URL_BASE
import com.felipearaujo.data.remote.RemoteNewsRepository
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_BASE)
                .build()
    }

    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso {
        return Picasso.Builder(context)
                .loggingEnabled(true)
                .build()
    }

    @Provides
    @Singleton
    fun providesRemoteNewsRepository(retrofit: Retrofit): RemoteNewsRepository = RemoteNewsRepository(retrofit)

    @Provides
    @Singleton
    fun providesNewsRepository(remote: RemoteNewsRepository): NewsRepository = NewsRepositoryImp(remote)

}