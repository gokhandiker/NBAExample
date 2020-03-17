package com.gkhn.nbaexample.domain.usecase.getplayerwithid

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

class GetPlayerWithIdUseCaseImpl(
    val playerRepositoryImpl: PlayerRepositoryImpl
) : GetPlayerWithId {

    override suspend fun invoke(id: Int): Output<PlayerDomainModel> {
        return playerRepositoryImpl.getPlayerWithId(id)
    }

}