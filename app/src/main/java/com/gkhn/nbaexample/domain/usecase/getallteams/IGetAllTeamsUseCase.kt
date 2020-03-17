package com.gkhn.nbaexample.domain.usecase.getallteams

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel

interface IGetAllTeamsUseCase {
    suspend fun getAllTeams() : Output<List<TeamDomainModel>>
}