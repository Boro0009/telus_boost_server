package com.telus.test.response

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.routing.Route
import io.ktor.locations.*
import io.ktor.response.respond
import io.ktor.response.respondText

@Location("/")
class Index

@Location("/{boostNumber}/Status/all_data")
data class AllDataLocation(val boostNumber: Int)

@Location("/{boostNumber}/WiFi/CONFIG")
data class ConfigLocation(val boostNumber: Int)

@Location("/{boostNumber}/Tools/CheckPwd")
data class CheckPwdLocation(val boostNumber: Int)

@Location("/{boostNumber}/WiFi/DEVICE")
data class WifiSettingsLocation(val boostNumber: Int)

@Location("/{boostNumber}/Tools/WifiPowerTable")
data class WifiPowerTableLocation(val boostNumber: Int)

fun Route.indexResponse(){
    get<Index>{
        call.respondText("Empty content", contentType = ContentType.Text.Plain)
    }
}

fun Route.allDataResponse(){
    get<AllDataLocation>{
        when{
            it.boostNumber in 1 ..5 -> call.respond(MockData().topologyMock(it.boostNumber))
            else -> call.respond(MockData().topologyMock(0))
        }
    }
}

fun Route.configResponse(){

    get<ConfigLocation>{
        call.respond(MockData().wifiConfigsMock())
    }

    post<ConfigLocation>{
        call.respond(MockData().resultOkMock())
    }
}

fun Route.checkPasswordResponse(){
    post<CheckPwdLocation>{
        call.respond(MockData().resultOkMock())
    }
}

fun Route.wifiSettingsResponse(){
    post<WifiSettingsLocation>{
        call.respond(MockData().resultOkMock())
    }
}
fun Route.wifiPowerTableResponse(){
    get<WifiPowerTableLocation>{
       call.respond(MockData().powerTableMock())
    }
}