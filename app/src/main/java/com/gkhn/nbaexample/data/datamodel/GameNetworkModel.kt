package com.gkhn.nbaexample.data.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameNetworkModel(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("home_team")
    @Expose
    val homeTeam: TeamNetworkModel,
    @SerializedName("home_team_score")
    @Expose
    val homeTeamScore: Int,
    @SerializedName("period")
    @Expose
    val period: Int,
    @SerializedName("postseason")
    @Expose
    val postseason: Boolean,
    @SerializedName("season")
    @Expose
    val season: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("time")
    @Expose
    val time: String,
    @SerializedName("visitor_team")
    @Expose
    val visitorTeam: TeamNetworkModel,
    @SerializedName("visitor_team_score")
    @Expose
    val visitorTeamScore: Int
)
