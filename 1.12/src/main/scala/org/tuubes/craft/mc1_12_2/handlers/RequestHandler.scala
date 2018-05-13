package org.tuubes.craft.mc1_12_2.handlers

import com.electronwill.nightconfig.json.JsonFormat
import org.tuubes.core.TuubesServer
import org.tuubes.craft.CraftAttach
import org.tuubes.craft.mc1_12_2.TuubesCraft1_12
import org.tuubes.craft.mc1_12_2.status.clientbound.ResponsePacket
import org.tuubes.craft.mc1_12_2.status.serverbound.RequestPacket

class RequestHandler extends ((RequestPacket, CraftAttach) => Unit) {
  override def apply(packet: RequestPacket, client: CraftAttach): Unit = {
    TuubesCraft1_12.logger.debug("Handling RequestPacket")
    val f = JsonFormat.minimalInstance()
    val json = f.createConfig()
    json.set("version.name", "1.12.2")
    json.set("version.protocol", 340)
    json.set("players.max", 100)
    json.set("players.online", 10)
    json.set("description.text", s"Tuubes ${TuubesServer.Version} :3")
    val jsonString = f.createWriter().writeToString(json)
    val response = new ResponsePacket(jsonString)
    client.send(response, jsonString.length * 2)
  }
}
