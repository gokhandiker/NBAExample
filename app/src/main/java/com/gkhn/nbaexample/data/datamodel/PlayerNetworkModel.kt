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
    val team: TeamNetwork,
    @SerializedName("weight_pounds")
    @Expose
    val weightPounds: Int
){
    data class TeamNetwork (

        @SerializedName("id")
        @Expose
        val id: Int,
        @SerializedName("abbreviation")
        @Expose
        val abbreviation: String,
        @SerializedName("city")
        @Expose
        val city: String,
        @SerializedName("conference")
        @Expose
        val conference: String,
        @SerializedName("division")
        @Expose
        val division: String,
        @SerializedName("full_name")
        @Expose
        val fullName: String,
        @SerializedName("name")
        @Expose
        val name: String
    )

}



