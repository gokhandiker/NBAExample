package com.gkhn.nbaexample.domain.domainmodel

data class PlayerDomainModel(
    val firstName: String,
    val lastName: String,
    val position: String,
    val heightInches: Int,
    val teamName:String
)