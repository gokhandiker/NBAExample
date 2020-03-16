package com.gkhn.nbaexample.data.remote

import com.gkhn.nbaexample.data.datamodel.Player
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

// https://www.balldontlie.io/#get-all-players
interface NbaService {

    @GET("players")
    fun getAllPlayers() : Deferred<List<Player>>

}