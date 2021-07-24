package mycorda.app.website

import org.http4k.core.*
import org.http4k.routing.ResourceLoader.Companion.Classpath
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.routing.static

class RoutingController(vHost: String) : HttpHandler {
    override fun invoke(p: Request) = routes(p)

    private val routes: RoutingHttpHandler = routes(
        "/" bind Method.GET to {
            Response(Status.TEMPORARY_REDIRECT).header("Location", "$vHost/static/home.html")
        },
        "/static" bind static(Classpath("www"))


//        "/home" bind Method.GET to {
//            val html = TemplateProcessor().process(
//                "/templates/home.html",
//                emptyMap<String, Any>()
//            )
//            Response(Status.OK).body(html)
//        }
    )
}