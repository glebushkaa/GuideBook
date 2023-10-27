package com.gm.ai.guidebook.data.network.dto.auth

import com.google.gson.annotations.SerializedName

/**
 * Created by gle.bushkaa email(gleb.mokryy@gmail.com) on 10/27/2023
 */

data class AuthResponseDto(
    @SerializedName("accessToken") val accessToken: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("message") val message: String? = null,
)
