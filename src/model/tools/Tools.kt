package com.telus.test.model.tools

import com.fasterxml.jackson.annotation.JsonProperty

data class LedColorData(
        @JsonProperty("device_mac") val deviceMac: String?,
        @JsonProperty("index") val index: String?,
        @JsonProperty("color") val color: ColorType? = null,
        @JsonProperty("brightness") val brightness: BrightnessType? = null){
    enum class ColorType{
        @JsonProperty("0") GREEN,
        @JsonProperty("1") YELLOW,
        @JsonProperty("2") RED,
        @JsonProperty("3") ORANGE,
        @JsonProperty("4") WHITE,
        @JsonProperty("5") PURPLE,
        @JsonProperty("6") BLUE
    }
    enum class BrightnessType{
        @JsonProperty("0") DARK,
        @JsonProperty("1") MEDIUM,
        @JsonProperty("2") BRIGHTEST
    }
}

enum class PasswordResultType{
    @JsonProperty("OK") OK,
    @JsonProperty("Failed") FAILED,
    @JsonProperty("check_password_failed") PASSWORD_FAILED
}

data class ControlInternetStatus(@JsonProperty("internet_control_status") val internetControlStatus: InternetControlStatus? = null){
    enum class InternetControlStatus{
        @JsonProperty("On") ON,
        @JsonProperty("Off") OFF
    }
}

data class InstalledListDevices(val nodes: List<InstalledDevice>)

data class InstalledDevice(
        @JsonProperty("mac") val mac: String? = "",
        @JsonProperty("name") val name: String? = "",
        @JsonProperty("parent_id") val parentId: String? = "",
        @JsonProperty("status") val status: StatusType? = null){
    enum class StatusType{
        @JsonProperty("on") ON,
        @JsonProperty("off") OFF
    }
}