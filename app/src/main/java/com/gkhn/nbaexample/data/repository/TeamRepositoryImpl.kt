package com.gkhn.nbaexample.data.repository

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.datamodel.TeamNetworkModel
import com.gkhn.nbaexample.data.remote.NbaService
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel
import com.gkhn.nbaexample.domain.repository.TeamRepository
import com.gkhn.nbaexample.util.toDomainModel
import java.lang.Exception

class TeamRepositoryImpl(
    val nbaService: NbaService
) : TeamRepository {
    override suspend fun getAllTeams(): Output<List<TeamDomainModel>> {
        return try {
            val result = nbaService.getAllTeams().await()
            Output.Success(mapData(result.data))
        } catch (ex: Exception) {
            Output.Error(ex)
        }
    }

    private fun mapData(data: List<TeamNetworkModel>): List<TeamDomainModel> {
        var list:ArrayList<TeamDomainModel> = arrayListOf()

        data.forEach { model ->
            list.add(model.toDomainModel())
        }
        return list
    }

}