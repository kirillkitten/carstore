package com.khudyakov.carstore.di

import android.content.Context
import androidx.room.Room
import com.khudyakov.carstore.data.car.database.CarDao
import com.khudyakov.carstore.data.car.database.CarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCarDao(@ApplicationContext context: Context): CarDao = Room
        .databaseBuilder(context, CarDatabase::class.java, "cars")
        .build()
        .carDao()
}
