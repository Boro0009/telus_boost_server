package com.telus.test.model.tools

import com.fasterxml.jackson.annotation.JsonProperty

data class RemoveNodeRequest(val target: String)

data class PasswordRequest(
        @JsonProperty("password") val password: String,
        @JsonProperty("password_check") val passwordCheck: String? = null)

data class RebootRequest(
        @JsonProperty("password_check") val passwordCheck: String,
        val target: String = "ALL")
