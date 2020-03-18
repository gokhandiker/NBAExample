package com.gkhn.nbaexample.data.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllPlayersNetworkModel(
    @SerializedName("data") @Expose val data: List<PlayerNetworkModel>
)