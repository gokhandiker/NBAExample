package com.gkhn.nbaexample.data.repository


import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.datamodel.PlayerNetworkModel
import com.gkhn.nbaexample.data.remote.NbaService
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel
import com.gkhn.nbaexample.domain.repository.PlayerRepository
import com.gkhn.nbaexample.util.toDomainModel
import java.lang.Exception


class PlayerRepositoryImpl( private val nbaService: NbaService) : PlayerRepository {

    override suspend fun getAllPlayers(): Output<List<PlayerDomainModel>> {
        return try {
            val result = nbaService.getAllPlayers().await()
            Output.Success(mapData(result.data))
        } catch (ex: Exception) {
            Output.Error(ex)
        }
    }

    override suspend fun getPlayerWithId(id: Int): Output<PlayerDomainModel> {
        return try {
            val result = nbaService.getPlayerWithId(id).await()
            Output.Success(result.toDomainModel())
        } catch (ex: Exception) {
            Output.Error(ex)
        }
    }

    private fun mapData(data: List<PlayerNetworkModel>): List<PlayerDomainModel> {
        var list : ArrayList<PlayerDomainModel> = arrayListOf()
        data.forEach{
            list.add(it.toDomainModel())
        }
        return list
    }


}