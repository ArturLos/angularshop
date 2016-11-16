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
  var job: SynchronizationJob = _

  @RequestMapping(method = Array(RequestMethod.GET))
  def synchronizuj(): Unit = {
    job.source = Source.fromFile( new File("playroom_xml_1_0.xml"), "UTF-8")
    job.synchronize()
  }

}
