package com.gkhn.nbaexample.data.datamodel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class MetaNetworkModel(
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("current_page") @Expose val currentPage: Int,
    @SerializedName("next_page") @Expose val nextPage: Int,
    @SerializedName("per_page") @Expose val perPage: Int,
    @SerializedName("total_count") @Expose val totalCount: Int
)
