package pl.angularshop.synchronizacja

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component
import pl.angularshop.kategoria.Kategoria
import pl.angularshop.produkt.Produkt

import scala.collection.JavaConversions._
import scala.xml.MetaData
import scala.xml.pull._

@Component
class PlayroomXMLEventParser {
  val LOG: Logger = LoggerFactory.getLogger(this.getClass)

  def parseNextProdukt(xMLEventReader: XMLEventReader): Produkt = {
    var produkt: Produkt = null
    var event: XMLEvent = null
    var endProdukt = false
    while(!endProdukt && xMLEventReader.hasNext) {
      event = xMLEventReader.next
      event match {
        case EvElemStart(_, "offer", _, _) => {
          produkt = new Produkt()
        }
        case EvElemEnd(_, "offer") => {
          endProdukt = true
        }
        case EvElemStart(_, "param", attrs, _) => {
          parseParam(xMLEventReader, event, produkt)
        }
        case ev => LOG.info(s"Nie obsługiwany event ${ev}.")
      }
    }
    produkt
  }

  private def parseParam(xMLEventReader: XMLEventReader, event: XMLEvent, produkt: Produkt): Unit = {
    val metaData: MetaData = event.asInstanceOf[EvElemStart].attrs
    val fieldCode = metaData("name").head.text
    val fieldValue: String = xMLEventReader.next().asInstanceOf[EvText].text
    fieldCode match {
      case "product_code" => produkt.setKod(fieldValue)
      case "name" => produkt.setNazwa(fieldValue)
      case "desc" => produkt.setOpis(excapeProduktOpis(fieldValue))
      case "image" => produkt.getObrazek+=fieldValue
      case "cat" => produkt.getKategoria+=generateKategoria(fieldValue)
      case kod => LOG.info(s"Nie obsługiwany kod pola ${kod}.")
    }
    xMLEventReader.next()//zdjęcie EvElemEnd(null,param) ze stosu
  }

  def generateKategoria(fieldValue: String): Kategoria = {
    val kategoriaSciezka: Array[String] = fieldValue.split('^')
    val nazwa: String = kategoriaSciezka(0)
    var kod: String = kategoriaSciezka(0).toUpperCase.replaceAll("[^A-Z0-9]","_") // dorobić zamianę znaków locales na na bez ogonków
    new Kategoria(kod, nazwa)
  }

  def excapeProduktOpis(opis: String): String = {
    return if (opis != null && opis.length>0) {
      val endIndex = opis.indexOf("<xml>")
      if(endIndex>0)
        opis.substring(0, endIndex)
      else opis
    } else
      ""
  }

}
