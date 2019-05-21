package hu.bme.szn.randomjokes.mock


import hu.bme.szn.randomjokes.network.JokeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideWeatherApi(): JokeApi = MockJokeApi()

}