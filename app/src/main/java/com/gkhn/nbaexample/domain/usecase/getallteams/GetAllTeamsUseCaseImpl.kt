package com.gkhn.nbaexample.domain.usecase.getallteams

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.repository.TeamRepositoryImpl
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel

class GetAllTeamsUseCaseImpl(
    val teamRepositoryImpl: TeamRepositoryImpl
) : IGetAllTeamsUseCase {
    override suspend fun getAllTeams(): Output<List<TeamDomainModel>> {
        return teamRepositoryImpl.getAllTeams()
    }

}