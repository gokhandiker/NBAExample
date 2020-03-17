package com.gkhn.nbaexample.data.remote

import com.gkhn.nbaexample.data.datamodel.AllPlayersNetworkModel
import com.gkhn.nbaexample.data.datamodel.AllTeamsNetworkModel
import com.gkhn.nbaexample.data.datamodel.PlayerNetworkModel
import com.gkhn.nbaexample.data.datamodel.TeamNetworkModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

// https://www.balldontlie.io/#get-all-players
interface NbaService {

    @GET("players")
    fun getAllPlayers() : Deferred<AllPlayersNetworkModel>

    @GET("players/{id}")
    fun getPlayerWithId(@Path("id") id : Int) : Deferred<PlayerNetworkModel>

    @GET("teams")
    fun getAllTeams(): Deferred<AllTeamsNetworkModel>

}