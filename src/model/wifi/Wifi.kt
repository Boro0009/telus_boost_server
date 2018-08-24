package com.telus.test.model.wifi

import com.fasterxml.jackson.annotation.JsonProperty


data class DeviceDataParameters(
        @JsonProperty("device_mac") val deviceMac: String? = null,
        @JsonProperty("device_name") val deviceName: String? = null,
        @JsonProperty("config_type") val configType: ConfigType? = null){
    enum class ConfigType{
        @JsonProperty("unconfigured") UNCONFIGURED,
        @JsonProperty("configured_master") MASTER,
        @JsonProperty("configured_slave") SLAVE
    }
}

data class WifiConfig(
        @JsonProperty("password_check") val passwordCheck: String? = null,
        @JsonProperty("interface") val wifiInterface: String?,
        @JsonProperty("ssid") val ssid: String? = null,
        @JsonProperty("password") val password: String? = null)

data class WifiConfigListRequest(@JsonProperty("wifi_config") val wifiConfig: List<WifiConfig>)