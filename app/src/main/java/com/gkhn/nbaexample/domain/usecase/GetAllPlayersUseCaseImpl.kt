package com.gkhn.nbaexample.domain.usecase


import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

class GetAllPlayersUseCaseImpl(
    val playerRepositoryImpl: PlayerRepositoryImpl
) : GetAllPlayersUseCase {
    override suspend fun invoke(): Output<List<PlayerDomainModel>> {
        return playerRepositoryImpl.getAllPlayers()
    }

}