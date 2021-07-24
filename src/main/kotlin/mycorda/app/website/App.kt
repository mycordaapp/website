package mycorda.app.website

import org.http4k.server.Jetty
import org.http4k.server.asServer


fun main(args: Array<String>) {

    val port = if (args.isNotEmpty()) args[0] else "8080"
    val vhost = if (args.size > 1) args[1] else "http://localhost:8080"

    val app = RoutingController(vhost)
    val server =
        app.asServer(Jetty(port.toInt()))
    println("Starting server on port $port with vhost of $vhost")
    server.start()
}