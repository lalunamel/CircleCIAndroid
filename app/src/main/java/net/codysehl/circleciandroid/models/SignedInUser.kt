package net.codysehl.circleciandroid.models

import com.google.gson.annotations.SerializedName

data class SignedInUser(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val name: String,
    @SerializedName("github_id")
    val githubId: String,
    val login: String
)