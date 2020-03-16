package com.gkhn.nbaexample.util

import com.gkhn.nbaexample.data.datamodel.PlayerNetworkModel
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel

fun PlayerNetworkModel.toDomainModel() = PlayerDomainModel(
    firstName = this.firstName,
    lastName = this.lastName,
    position = this.position,
    heightInches = this.heightInches,
    teamName = this.team.name
)