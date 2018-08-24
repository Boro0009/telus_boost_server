package com.telus.test.model.status

import com.telus.test.model.tools.InstalledDevice
import com.fasterxml.jackson.annotation.JsonProperty

data class StatusNode(
        @JsonProperty("fw_ver") val firmwareVersionDevice: String? = "",
        @JsonProperty("sn") val serialNumberDevice: String? = "",
        @JsonProperty("device_mac") val deviceMac: String? = "",
        @JsonProperty("device_name") val deviceName: String? = "",
        @JsonProperty("device_id") val deviceId: String? = "",
        @JsonProperty("bssid_2g") val bssid2g: String? = "",
        @JsonProperty("bssid_5g") val bssid5g: String? = "",
        @JsonProperty("parent_id") val parentId: String? = "",
        @JsonProperty("sta_num") val stationsNumberConnectedToDevice: String? = "",
        @JsonProperty("connect_type") val connectType: String? = "",
        @JsonProperty("connect_rssi") val connectRssi: String? = "",
        @JsonProperty("model_name") val modelName: String? = "",
        @JsonProperty("uptime") val countingTimeFromBootUpToNow: String? = "")

data class StatusStation(
        @JsonProperty("station_mac") val stationMac: String? = "",
        @JsonProperty("station_name") val stationName: String? = "",
        @JsonProperty("parent_id") val parentId: String? = "",
        @JsonProperty("station_ip") val ipAddress: String? = "",
        @JsonProperty("last_connect") val lastConnected: String? = "",
        val online: String? = "")

data class InstalledList(val nodes: List<InstalledDevice> = emptyList())

data class GroupData(@JsonProperty("gp_id") val groupId: String? = "")

data class MacLeds(val leds: List<MacLed> = emptyList())

data class MacLed(
        @JsonProperty("color") val color: LedColor = LedColor.EMPTY,
        @JsonProperty("brightness") val brightness: String? = "")

enum class LedColor{
    @JsonProperty("0") GREEN,
    @JsonProperty("1") YELLOW,
    @JsonProperty("2") RED,
    @JsonProperty("3") ORANGE,
    @JsonProperty("4") WHITE,
    @JsonProperty("5") PURPLE,
    @JsonProperty("6") BLUE,
    @JsonProperty("") EMPTY,
}