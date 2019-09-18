package com.pandacode.task.qupas.qupasomdb.db.entity


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source")
    val source: String,
    @SerializedName("Value")
    val value: String
)