package pl.angularshop.zamowienie

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.angularshop.produkt.ProduktRepository

import scala.collection.JavaConversions._

@Service
class ZamowienieService {

  @Autowired
  var zamowienieRepository: ZamowienieRepository = _

  @Autowired
  var daneDostawyRepository: DaneDostawyRepository = _

  @Autowired
  var produktRepository: ProduktRepository  = _

  def zapiszZamowienie(zamowienie: Zamowienie): Zamowienie = {
    zamowienie.produkty = zamowienie.produkty.map(p=>
      produktRepository.findByKod(p.getKod)
    )
    return zamowienieRepository.save(zamowienie)
  }

}