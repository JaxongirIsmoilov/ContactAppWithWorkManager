package uz.gita.jaxongir.contactappwithworkmanager.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.AppDatabase
import uz.gita.jaxongir.contactappwithworkmanager.data.source.local.room.dao.ContactDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {

    @[Provides Singleton]
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "ContactsAppDB").build()


    @[Provides Singleton]
    fun providesContactsDao(appDatabase: AppDatabase): ContactDao = appDatabase.getContactDao()

}