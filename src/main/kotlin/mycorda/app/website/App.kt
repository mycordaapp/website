package mycorda.app.website

import org.http4k.server.Jetty
import org.http4k.server.asServer


fun main(args: Array<String>) {

    val vhost = "http://localhost:8080"
    val port = "8080"

    val app = RoutingController(vhost)
    val server =
        app.asServer(Jetty(port.toInt()))
    println("Starting server on port $port")
    server.start()
}