package com.dev.ninhohub.core.database.di

import android.content.Context
import androidx.room.Room
import com.dev.ninhohub.core.database.NinhoDatabase
import com.dev.ninhohub.core.database.dao.GroceryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NinhoDatabase {
        return Room.databaseBuilder(
            context,
            NinhoDatabase::class.java,
            "ninho_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideGroceryDao(database: NinhoDatabase): GroceryDao {
        return database.groceryDao()
    }
}
