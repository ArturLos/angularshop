package pl.angularshop.zamowienie

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonInclude
import pl.angularshop.produkt.Produkt
import pl.angularshop.zamowienie.Zamowienie.ZamowienieDto

import scala.collection.JavaConversions._
import scala.collection._

object Zamowienie{
  @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
  class ZamowienieDto(
   val produkty: mutable.Set[Produkt#ProduktDto],
   val daneDostawy: DaneDostawy
  )
}

@Entity
case class Zamowienie() {

  @Id
  @GeneratedValue
  var id: Integer = _

  @ManyToMany(cascade = Array(CascadeType.ALL))
  var produkty: java.util.Set[Produkt] = mutable.Set[Produkt]()

  @OneToOne(cascade = Array(CascadeType.ALL))
  var daneDostawy: DaneDostawy = _

  def toDto(): ZamowienieDto = {
    new ZamowienieDto(
      produkty.map(_.toDto),
      daneDostawy)
  }
}
