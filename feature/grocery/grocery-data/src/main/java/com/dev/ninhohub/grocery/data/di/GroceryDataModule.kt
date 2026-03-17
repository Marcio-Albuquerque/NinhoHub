package com.dev.ninhohub.grocery.data.di

import com.dev.ninhohub.grocery.data.repository.GroceryRepositoryImpl
import com.dev.ninhohub.grocery.domain.repository.GroceryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GroceryDataModule {

    @Binds
    @Singleton
    abstract fun bindGroceryRepository(
        groceryRepositoryImpl: GroceryRepositoryImpl
    ): GroceryRepository
}
