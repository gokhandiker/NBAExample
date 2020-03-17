package com.gkhn.nbaexample.domain.usecase.getplayerwithid

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

interface GetPlayerWithId {
    suspend fun invoke(id:Int): Output<PlayerDomainModel>
}