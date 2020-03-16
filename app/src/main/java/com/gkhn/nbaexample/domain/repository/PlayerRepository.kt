package com.gkhn.nbaexample.domain.repository

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

interface PlayerRepository {
  suspend  fun getAllPlayers() : Output<List<PlayerDomainModel>>
}