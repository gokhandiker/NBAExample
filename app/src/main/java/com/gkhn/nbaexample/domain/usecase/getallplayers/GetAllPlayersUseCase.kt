package com.gkhn.nbaexample.domain.usecase.getallplayers

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

interface GetAllPlayersUseCase {
    suspend fun invoke(): Output<List<PlayerDomainModel>>
}