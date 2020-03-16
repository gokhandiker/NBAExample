package com.gkhn.nbaexample.data.remote

import com.gkhn.nbaexample.data.datamodel.AllPlayersNetworkModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

// https://www.balldontlie.io/#get-all-players
interface NbaService {

    @GET("players")
    fun getAllPlayers() : Deferred<AllPlayersNetworkModel>

}