package com.felipearaujo.data.di

import android.content.Context
import com.felipearaujo.data.BuildConfig
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.data.NewsRepositoryImp
import com.felipearaujo.data.URL_BASE
import com.felipearaujo.data.local.LocalNewsRepository
import com.felipearaujo.data.local.LocalNewsRepositoryImp
import com.felipearaujo.data.remote.ArticleDeserializer
import com.felipearaujo.data.remote.NewsApiService
import com.felipearaujo.data.remote.RemoteNewsRepository
import com.felipearaujo.data.remote.RemoteNewsRepositoryImp
import com.felipearaujo.model.Article
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.realm.Realm
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
    fun prividesGson(): Gson {
        val gson = GsonBuilder().registerTypeAdapter(Article::class.java, ArticleDeserializer())
        return gson.create()
    }

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL_BASE)
            .build()


    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso =
            Picasso.Builder(context)
                    .loggingEnabled(true)
                    .build()

    /**
     * Repository (local and remote)
     */
    @Provides
    @Singleton
    fun providesNewsRepository(
            appContext: Context, remote: RemoteNewsRepository, local: LocalNewsRepository
    ): NewsRepository = NewsRepositoryImp(appContext, remote, local)

    /**
     * Remote repository
     */
    @Provides
    @Singleton
    fun providesRemoteNewsRepository(service: NewsApiService): RemoteNewsRepository =
            RemoteNewsRepositoryImp(service, BuildConfig.API_KEY)

    /**
     * Local repository
     */
    @Provides
    @Singleton
    fun providesLocalNewsRepository(realm: Realm): LocalNewsRepository = LocalNewsRepositoryImp(realm)


    @Provides
    @Singleton
    fun providesNewsApiService(retrofit: Retrofit): NewsApiService = retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun providesRealm(): Realm = Realm.getDefaultInstance()


}