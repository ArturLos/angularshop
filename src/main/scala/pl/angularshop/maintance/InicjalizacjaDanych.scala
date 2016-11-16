package pl.angularshop.maintance

import org.springframework.beans.factory.annotation._
import org.springframework.web.bind.annotation._
import pl.angularshop.katalog.KatalogService
import pl.angularshop.kategoria.{Kategoria, KategoriaRepository, KategoriaService}
import pl.angularshop.produkt.{Produkt, ProduktRepository}


@RestController
class InicjalizacjaDanych {

  @Autowired
  var produktRepository: ProduktRepository = _
  @Autowired
  var kategoriaRepository: KategoriaRepository = _
  @Autowired
  var katalogService: KatalogService = _
  
  
  @RequestMapping(Array("/inicjalizujProdukt"))
  def inicjalizujProdukt: Unit = {
    var produkt: Produkt = new Produkt("WIB_MICH_W", "Mark 4","Delikatność w każdym milimetrze","Miekki z naturalnych materiałów")
    produkt.getObrazek().add("img/dildos1.jpg")
    katalogService.saveProdukt(produkt)
    
    produkt = new Produkt("WIB_MARK_4", "Michał Wielki","Zawsze tam gdzie trzeba","Doskonale <b>dopasowuje się</b> do kształtu Twojego ciała.")
    produkt.getObrazek().add("img/dildos1.jpg")
    katalogService.saveProdukt(produkt)
    
    produkt = new Produkt("HAR_ZAS", "Harnes Zasada","Gotowy specjalnie dla Ciebie","")
    produkt.getObrazek().add("img/dildos1.jpg")
    katalogService.saveProdukt(produkt)
    
  }
  
  @RequestMapping(Array("/inicjalizujKategoria"))
  def inicjalizujKategoria: Unit = {
    var kategoria = new Kategoria("DILDO", "Dilda")
    kategoriaRepository.save(kategoria)
    kategoria = new Kategoria("WIBRA", "Wibratory")
    kategoriaRepository.save(kategoria)
    kategoria = new Kategoria("PREZE", "Prezerwatywy")
    kategoriaRepository.save(kategoria)
    kategoria = new Kategoria("BIELIZ", "Bielizna")
    kategoriaRepository.save(kategoria)
  }
}