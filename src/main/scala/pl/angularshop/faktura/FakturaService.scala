package pl.angularshop.faktura

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.angularshop.zamowienie.{Zamowienie, ZamowienieRepository}

@Service
class FakturaService {

  val logger: Logger = LoggerFactory.getLogger("FakturaService")

  @Autowired
  var fakturaRepository: FakturaRepository = _

  @Autowired
  var zamowienieRepository: ZamowienieRepository = _

  def utworzFaktureId(zamowienieId: Int): Int = {
    logger.info("Tworzenie faktury dla zamowienia id: {}", zamowienieId)
    val faktura = utworzFakture(zamowienieRepository.findOne(zamowienieId))
    logger.info("Faktura id {} utworzona", faktura.id)
    return faktura.id
  }

  def utworzFakture(zamowienie: Zamowienie): Faktura = {
    val faktura: Faktura = Faktura()
    faktura.zamowienie = zamowienie
    return fakturaRepository.save(faktura)
  }
}
