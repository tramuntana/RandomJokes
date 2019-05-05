package hu.bme.szn.randomjokes.repository

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

import hu.bme.szn.randomjokes.repository.room.RoomRepository

@Suppress("unused")
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(roomRepository: RoomRepository): Repository

}