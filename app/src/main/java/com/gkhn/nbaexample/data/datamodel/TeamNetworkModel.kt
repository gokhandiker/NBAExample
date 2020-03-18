package com.gkhn.nbaexample.data.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TeamNetworkModel(

    @SerializedName("id") @Expose val id: Int,
    @SerializedName("abbreviation") @Expose val abbreviation: String,
    @SerializedName("city") @Expose val city: String,
    @SerializedName("conference") @Expose val conference: String,
    @SerializedName("division") @Expose val division: String,
    @SerializedName("full_name") @Expose val fullName: String,
    @SerializedName("name") @Expose val name: String
)