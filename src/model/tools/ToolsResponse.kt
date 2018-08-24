package com.telus.test.model.tools

import com.fasterxml.jackson.annotation.JsonProperty

data class BaseResponse(val result: BaseResponseType? = null){
    enum class BaseResponseType{
        @JsonProperty("OK") OK,
        @JsonProperty("Failed") FAILED
    }
}

data class PasswordResponse(val result: PasswordResponseType? = null){
    enum class PasswordResponseType{
        @JsonProperty("OK") OK,
        @JsonProperty("check_password_failed") CHECK_PASSWORD_FAILED,
        @JsonProperty("Failed") FAILED
    }
}

data class PowerTable(@JsonProperty("index") val index: String? = "",
                      @JsonProperty("atable") val androidTable: AndroidTable? = null,
                      @JsonProperty("itable") val iosTable: IosTable? = null)

data class AndroidTable(val alv1: String? = "",
                        val alv2: String? = "",
                        val alv3: String? = "",
                        val alv4: String? = "")

data class IosTable(val ilv1: String? = "",
                    val ilv2: String? = "",
                    val ilv3: String? = "",
                    val ilv4: String? = "",
                    val ilv5: String? = "",
                    val ilv6: String? = "",
                    val ilv7: String? = "",
                    val ilv8: String? = "")

data class WifiPowerTableResponse(val workingBand: String? = "",
                                  val powerTableList: List<PowerTable> = emptyList(),
                                  val arrayWorkBand: Map<String, String> = emptyMap())


