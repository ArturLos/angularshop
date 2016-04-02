package pl.angularshop.synchronizacja

import java.io.File

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import scala.io.Source
import scala.xml.pull._

@RestController
@RequestMapping(Array("/synchronizacja"))
class KatalogSynchronizacja {
  @
  Autowired
  var job: HuaJob = _

  @RequestMapping(method = Array(RequestMethod.GET))
  def synchronizuj(): Unit = {
    val file: File = new File("playroom_xml_1_0.xml")
    val source: Source = Source.fromFile(file)
    job.synchronize(source)
  }

}
