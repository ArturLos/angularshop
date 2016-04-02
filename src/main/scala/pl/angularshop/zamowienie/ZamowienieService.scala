package pl.angularshop.zamowienie

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ZamowienieService {

  @Autowired
  var zamowienieRepository: ZamowienieRepository = _

  @Autowired
  var daneDostawyRepository: DaneDostawyRepository = _

  def zapiszZamowienie(zamowienie: Zamowienie): Unit = {
    daneDostawyRepository.save(zamowienie.daneDostawy)
    zamowienieRepository.save(zamowienie)
  }

}