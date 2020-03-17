package com.gkhn.nbaexample.domain.repository

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel

interface TeamRepository {

    suspend fun getAllTeams() : Output<List<TeamDomainModel>>
}