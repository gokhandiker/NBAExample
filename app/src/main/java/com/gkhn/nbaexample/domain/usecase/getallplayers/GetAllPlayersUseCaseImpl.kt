package com.gkhn.nbaexample.domain.usecase.getallplayers


import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel
import com.gkhn.nbaexample.domain.usecase.getallplayers.GetAllPlayersUseCase

class GetAllPlayersUseCaseImpl(
    val playerRepositoryImpl: PlayerRepositoryImpl
) : GetAllPlayersUseCase {
    override suspend fun invoke(): Output<List<PlayerDomainModel>> {
        return playerRepositoryImpl.getAllPlayers()
    }

}