package com.telus.test.model.status

import com.fasterxml.jackson.annotation.JsonProperty

data class  StatusTopologyResponse(
        @JsonProperty("nodes") val apNodes: List<StatusNode> = emptyList())

data class StatusAllDataResponse(val topologyData: StatusTopologyResponse? = null,
                                 val installedList: InstalledList? = null,
                                 val groupId: GroupData? = null,
                                 val arrayLeds: Map<String, MacLeds> = emptyMap())

data class StatusStationResponse(val stations: List<StatusStation> = emptyList())