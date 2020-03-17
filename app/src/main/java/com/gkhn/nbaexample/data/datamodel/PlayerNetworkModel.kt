package com.gkhn.nbaexample.data.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlayerNetworkModel(

    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("height_feet")
    @Expose
    val heightFeet: Int,
    @SerializedName("height_inches")
    @Expose
    val heightInches: Int,
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @SerializedName("position")
    @Expose
    val position: String,
    @SerializedName("team")
    @Expose
    val team: TeamNetworkModel,
    @SerializedName("weight_pounds")
    @Expose
    val weightPounds: Int
)


