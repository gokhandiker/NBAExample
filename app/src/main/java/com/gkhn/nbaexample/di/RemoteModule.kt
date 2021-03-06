package com.gkhn.nbaexample.di

import android.content.Context
import com.gkhn.nbaexample.data.remote.NbaService
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import com.gkhn.nbaexample.data.repository.TeamRepositoryImpl
import com.gkhn.nbaexample.domain.usecase.getallplayers.GetAllPlayersUseCaseImpl
import com.gkhn.nbaexample.domain.usecase.getallteams.GetAllTeamsUseCaseImpl
import com.gkhn.nbaexample.domain.usecase.getplayerwithid.GetPlayerWithIdUseCaseImpl
import com.gkhn.nbaexample.ui.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {

    single {
        createWebService<NbaService>(
            okHttpClient = createHttpClient(context = androidContext()),
            factory = RxJava2CallAdapterFactory.create(),
            baseUrl = "https://www.balldontlie.io/api/v1/"
        )
    }


    factory { PlayerRepositoryImpl(nbaService = get()) }
    factory { TeamRepositoryImpl(nbaService = get()) }

    factory { GetAllPlayersUseCaseImpl(playerRepositoryImpl = get())}

    factory { GetPlayerWithIdUseCaseImpl(playerRepositoryImpl = get()) }

    factory { GetAllTeamsUseCaseImpl(teamRepositoryImpl = get()) }

    viewModel { MainViewModel(getAllPlayersUseCaseImpl = get(), getPlayerWithIdUseCase = get(),getAllTeamUseCaseImpl = get()) }
}


/* Returns a custom OkHttpClient instance with interceptor. Used for building Retrofit service */
fun createHttpClient(context: Context): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.readTimeout(5 * 60, TimeUnit.SECONDS)
    return client.addInterceptor {
        val original = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.header("Content-Type", "application/json")
        val request = requestBuilder.method(original.method, original.body).build()
        return@addInterceptor it.proceed(request)
    }.build()
}

/* function to build our Retrofit service */
inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    factory: CallAdapter.Factory, baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}