package mycorda.app.website

import com.github.mustachejava.DefaultMustacheFactory
import java.io.*

class TemplateProcessor {
    fun process(templateFileName: String, model: Any): String {
        try {
            println("Processing $templateFileName")

            val text = TemplateProcessor::class.java.getResource(templateFileName).readText()
            val mf = DefaultMustacheFactory()
            val mustache = mf.compile(StringReader(text), "template.mustache")

            val bos = ByteArrayOutputStream()
            val writer = OutputStreamWriter(bos)
            mustache.execute(writer, model).flush()
            return bos.toString()

        } catch (ex: Exception) {
            ex.printStackTrace()
            return "Problem with template: ${ex.message}"
        }
    }

}