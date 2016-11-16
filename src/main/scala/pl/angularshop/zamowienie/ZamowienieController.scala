package pl.angularshop.zamowienie

import java.util

import org.activiti.engine.runtime.ProcessInstance
import org.activiti.engine.task.{Task, TaskQuery}
import org.activiti.engine.{IdentityService, RuntimeService, TaskService}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._
import org.springframework.web.bind.annotation._
import pl.angularshop.produkt.Produkt

import scala.collection.JavaConversions._

@RestController
@RequestMapping(Array("/zamowienie"))
@Scope("session")
class ZamowienieController {
  val logger: Logger = LoggerFactory.getLogger("ZamowienieController")

  var zamowienie: Zamowienie = Zamowienie()

  @Autowired
  var runtimeService: RuntimeService = _

  @Autowired
  var taskService: TaskService = _

  @Autowired
  var zamowienieService: ZamowienieService = _

  @Autowired
  var identityService: IdentityService = _

  var processInstance: ProcessInstance = _


  
  @RequestMapping(method = Array(RequestMethod.POST))
  def addProdukt(@RequestBody produkt: Produkt): Unit = {
    zamowienie.produkty += produkt

  }
  
  @RequestMapping(method = Array(RequestMethod.GET))
  def getZamowienie(): Zamowienie.ZamowienieDto = {
    logger.info("pobieram aktualne zamowienie. Produktow: " + zamowienie.produkty.size)
    zamowienie.toDto
    
  }

  @RequestMapping(value = Array("wyslij"), method = Array(RequestMethod.POST))
  def wyslijZamowienie(@RequestBody daneDostawy: DaneDostawy): Unit = {
    this.zamowienie.daneDostawy = daneDostawy
    this.zamowienie = zamowienieService.zapiszZamowienie(this.zamowienie)

    identityService.setAuthenticatedUserId("kermit")
    var initialData = collection.mutable.Map[String, String]()
    initialData.put("zamowienieId", this.zamowienie.id.toString())
    processInstance = runtimeService.startProcessInstanceByKey("zamowienieKlienta", initialData)
    identityService.setAuthenticatedUserId(null)

    this.zamowienie = Zamowienie()
  }

}
