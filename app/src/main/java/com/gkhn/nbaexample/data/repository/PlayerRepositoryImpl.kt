package com.gkhn.nbaexample.data.repository


import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.datamodel.AllPlayersNetworkModel
import com.gkhn.nbaexample.data.remote.NbaService
import com.gkhn.nbaexample.domain.repository.PlayerRepository
import java.lang.Exception


class PlayerRepositoryImpl( private val nbaService: NbaService) : PlayerRepository {
    override suspend fun getAllPlayers(): Output<AllPlayersNetworkModel> {
        return try {
            val result = nbaService.getAllPlayers().await()
            Output.Success(result)
        } catch (ex: Exception) {
            Output.Error(ex)
        }
    }


}