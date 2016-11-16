package pl.angularshop.synchronizacja

import java.io.File

import scala.xml.pull.XMLEventReader
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import scala.io.Source

@Service
class SynchronizationJob {
  val LOG: Logger = LoggerFactory.getLogger(this.getClass)

  @Autowired
  var playroomXMLEventParser: PlayroomXMLEventParser = _

  @Autowired
  var katalogServiceAdapter: SynchronizationKatalogServiceAdapter = _

  var source: Source = Source.fromFile( new File("playroom_xml_1_0.xml"))

  //@Scheduled(cron="0 1 * * * *")//co godzinę
  def synchronize(): Unit = {
    LOG.info("Rozpoczęto synchronizację z hurtownią")
    val reader: XMLEventReader = new XMLEventReader(source)
    while(reader.hasNext) {
      katalogServiceAdapter.saveProdukt(
        playroomXMLEventParser.parseNextProdukt(reader)
      )
    }
    LOG.info("Zakończono synchronizację z hurtownią")
  }

}
