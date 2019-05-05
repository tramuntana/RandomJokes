package hu.bme.szn.randomjokes.mock

import hu.bme.szn.randomjokes.mock.interceptors.MockInterceptor

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

import hu.bme.szn.randomjokes.network.NetworkModule


@Module
class MockNetworkModule {

    private val networkModule = NetworkModule()
/*
    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return networkModule.provideOkHttpClientBuilder(settings)
    }
*/

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.interceptors().add(builder.interceptors().size, MockInterceptor())

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }
/*
    @Provides
    @Singleton
    fun provideJokeApi(retrofit: Retrofit): JokeApi {
        return networkModule.provideJokeApi(retrofit)
    }
*/
}