package com.telus.test.model.wifi

import com.telus.test.model.tools.PasswordResultType
import com.fasterxml.jackson.annotation.JsonProperty


data class WirelessConfigurationResponse(@JsonProperty("wifi_config") val wifiConfig: List<WifiConfig> = emptyList())

data class WifiConfigResponse(
        @JsonProperty("result") val result: PasswordResultType? = null
)