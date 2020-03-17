package com.gkhn.nbaexample.util

import com.gkhn.nbaexample.data.datamodel.PlayerNetworkModel
import com.gkhn.nbaexample.data.datamodel.TeamNetworkModel
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel

fun PlayerNetworkModel.toDomainModel() = PlayerDomainModel(
    firstName = this.firstName,
    lastName = this.lastName,
    position = this.position,
    heightInches = this.heightInches,
    teamName = this.team.name
)


fun TeamNetworkModel.toDomainModel() = TeamDomainModel(
    id = this.id,
    abbreviation = this.abbreviation,
    city = this.city,
    fullName = this.fullName,
    name = this.name
)