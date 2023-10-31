package uz.gita.jaxongir.contactappwithworkmanager.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.gita.jaxongir.contactappwithworkmanager.data.source.remote.api.ContactApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContactApiModule {

    @[Provides Singleton]
    fun provideClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()

    @[Provides Singleton]
    fun provideRetrofit(okHttp: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://bb2d-195-158-16-140.ngrok-free.app/api/v1/")
            .build()

    @[Provides Singleton]
    fun contactApi(retrofit: Retrofit): ContactApi = retrofit.create()

}