package pl.angularshop.zamowienie

import collection.JavaConversions._
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._
import org.springframework.web.bind.annotation._
import pl.angularshop.produkt.Produkt

@RestController
@RequestMapping(Array("/zamowienie"))
@Scope("session")
class ZamowienieController {
  val logger: Logger = LoggerFactory.getLogger("ZamowienieController")

  var zamowienie: Zamowienie = Zamowienie()

  @Autowired
  var zamowienieService: ZamowienieService = _
  
  @RequestMapping(method = Array(RequestMethod.POST))
  def addProdukt(@RequestBody produkt: Produkt): Unit = {
    zamowienie.produkty += produkt

  }
  
  @RequestMapping(method = Array(RequestMethod.GET))
  def getZamowienie(): Zamowienie = {
    logger.info("pobieram aktualne zamowienie. Produktow: " + zamowienie.produkty.size())
    zamowienie
    
  }

  @RequestMapping(value = Array("wyslij"), method = Array(RequestMethod.POST))
  def wyslijZamowienie(@RequestBody zamowienie: Zamowienie): Unit = {
    zamowienieService.zapiszZamowienie(zamowienie)
    this.zamowienie = Zamowienie()
  }
  
}
