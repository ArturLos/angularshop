package pl.angularshop.synchronizacja

import javax.transaction.Transactional

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import pl.angularshop.katalog.KatalogService
import pl.angularshop.kategoria.{Kategoria, KategoriaService}
import pl.angularshop.produkt.Produkt

@Repository
class SynchronizationKatalogServiceAdapter {
  val LOG: Logger = LoggerFactory.getLogger(this.getClass)

  @Autowired
  var kategoriaService: KategoriaService = _
  @Autowired
  var produktService: KatalogService = _

  @Transactional
  def saveProdukt(produkt: Produkt): Unit = {
    if (produkt == null) return
    LOG.info(s"Zapisywanie produktu: ${Produkt.TO_STRING(produkt)}")
    LOG.info(s"Kategoria: ${if(produkt.getKategoria().size()>0) produkt.getKategoria().iterator().next().getKod else "-brak-kategori-"}")
    produktService.saveProdukt(produkt)
  }


}
