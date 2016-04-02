package pl.angularshop.synchronizacja

import scala.xml.pull.XMLEventReader
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import scala.io.Source

@Service
class HuaJob {
  val LOG: Logger = LoggerFactory.getLogger(this.getClass)

  @Autowired
  var bla: Bla = _

  @Autowired
  var sera: Fla = _

  def synchronize(source: Source): Unit = {
    LOG.info("Rozpoczęto synchronizację z hurtownią")
    val reader: XMLEventReader = new XMLEventReader(source)
    while(reader.hasNext) {
      sera.saveSourceData(
        bla.parseNextProdukt(reader)
      )
    }
    LOG.info("Zakończono synchronizację z hurtownią")
  }

}
