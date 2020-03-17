package com.gkhn.nbaexample.data.remote

import com.gkhn.nbaexample.data.datamodel.*
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

    @GET("teams/{id}")
    fun getTeamWithId(@Path("id") id : Int) : Deferred<TeamNetworkModel>

    @GET("games")
    fun getAllGames() : Deferred<AllGamesNetworkModel>

    @GET("games/{id}")
    fun getGameWithId(@Path("id") id : Int) : Deferred<GameNetworkModel>
}