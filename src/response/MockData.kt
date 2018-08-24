package com.telus.test.response

import com.telus.test.model.status.StatusNode
import com.telus.test.model.status.StatusTopologyResponse
import com.telus.test.model.tools.AndroidTable
import com.telus.test.model.tools.InstalledDevice
import com.telus.test.model.tools.IosTable
import com.telus.test.model.tools.PowerTable
import com.telus.test.model.wifi.WifiConfig
import com.telus.test.model.wifi.WifiConfigListRequest

class MockData{

    private val boostList: List<StatusNode> = listOf(baseStatusNode().copy(deviceMac = "48:8D:36:E6:FD:98", deviceName = "1"),
                                             baseStatusNode().copy(deviceMac = "48:8D:36:E6:F7:DC", deviceName = "2", parentId = "48:8D:36:E6:FD:98"),
                                             baseStatusNode().copy(deviceMac = "48:8D:36:E6:F7:DD", deviceName = "3", parentId = "48:8D:36:E6:FD:98"),
                                             baseStatusNode().copy(deviceMac = "48:8D:36:E6:F7:DE", deviceName = "4", parentId = "48:8D:36:E6:FD:98"),
                                             baseStatusNode().copy(deviceMac = "48:8D:36:E6:F7:97", deviceName = "5", parentId = "48:8D:36:E6:FD:98"))

    private val wifiConfigList: List<WifiConfig> = listOf(baseWifiConfig().copy(wifiInterface = "100"),
                                                  baseWifiConfig().copy(wifiInterface = "200"),
                                                  baseWifiConfig().copy(wifiInterface = "116"),
                                                  baseWifiConfig().copy(wifiInterface = "216"))

    private val powerTableList: List<PowerTable> = listOf(
            PowerTable(index = "table1",
                    androidTable = AndroidTable(alv1 = "-50", alv2 = "-62", alv3 = "-82", alv4 = "-87"),
                    iosTable = IosTable(ilv1 = "200", ilv2 = "193", ilv3 = "185", ilv4 = "175", ilv5 = "174", ilv6 = "173", ilv7 = "172", ilv8 = "171")),
            PowerTable(index = "table2",
                    androidTable = AndroidTable(alv1 = "-33", alv2 = "-45", alv3 = "-60", alv4 = "-70"),
                    iosTable = IosTable(ilv1 = "213", ilv2 = "209", ilv3 = "205", ilv4 = "185", ilv5 = "184", ilv6 = "183", ilv7 = "182", ilv8 = "180")),
            PowerTable(index = "table3",
                    androidTable = AndroidTable(alv1 = "-43", alv2 = "-55", alv3 = "-78", alv4 = "-84"),
                    iosTable = IosTable(ilv1 = "205", ilv2 = "198", ilv3 = "190", ilv4 = "178", ilv5 = "177", ilv6 = "176", ilv7 = "175", ilv8 = "174")),
            PowerTable(index = "table4",
                    androidTable = AndroidTable(alv1 = "-33", alv2 = "-45", alv3 = "-60", alv4 = "-70"),
                    iosTable = IosTable(ilv1 = "213", ilv2 = "209", ilv3 = "205", ilv4 = "185", ilv5 = "184", ilv6 = "183", ilv7 = "182", ilv8 = "180"))
            )
    fun topologyMock(boostNumber: Int = 0): Map<String, Any>{
        val tplg = StatusTopologyResponse(nodesMock(boostNumber))
        val installNodes = mapOf("nodes" to installedListMock(boostNumber))

        return mapOf("tplg" to tplg, "installed_list" to installNodes)
    }

    fun wifiConfigsMock(): WifiConfigListRequest = WifiConfigListRequest(wifiConfig = wifiConfigList)

    fun powerTableMock() = mapOf( "working_band" to "2GL,5G1L",
            "5G1H" to "table3",
            "5G1L" to "table1",
            "5G2H" to "table3",
            "5G2L" to "table1",
            "5G3H" to "table3",
            "5G3L" to "table1",
            "5G4H" to "table3",
            "5G4L" to "table1",
            "2GH" to "table4",
            "2GL" to "table2",
            "p_table" to powerTableList)

    fun resultOkMock() = mapOf("result" to "ok")

    private fun nodesMock(boostNumber: Int = 0): List<StatusNode>{
        return boostList.dropLast(boostList.size - boostNumber)
    }

    private fun installedListMock(boostNumber: Int = 0): List<InstalledDevice>{
        return boostList.dropLast(boostList.size - boostNumber).map { InstalledDevice(mac = it.deviceMac, name = it.deviceName, parentId = it.parentId) }
    }

    private fun baseStatusNode(): StatusNode = StatusNode(
            firmwareVersionDevice = "01",
            serialNumberDevice = "DWS1737000312-A",
            deviceId = "48:8D:36:E6:F7:DB",
            bssid2g = "48:8D:36:E6:FD:9A",
            bssid5g = "48:8D:36:E6:FD:98",
            parentId = "NULL",
            stationsNumberConnectedToDevice = "1",
            connectType = "Ether",
            connectRssi = "0",
            modelName = "WE410443-TS",
            countingTimeFromBootUpToNow = "512")

    private fun baseWifiConfig(): WifiConfig = WifiConfig(
            wifiInterface = "100",
            ssid = "telus_test",
            password = "test",
            passwordCheck = ""
    )
}