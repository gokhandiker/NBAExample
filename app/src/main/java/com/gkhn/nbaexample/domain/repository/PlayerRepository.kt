package com.gkhn.nbaexample.domain.repository

import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.datamodel.AllPlayersNetworkModel

interface PlayerRepository {
  suspend  fun getAllPlayers() : Output<AllPlayersNetworkModel>
}