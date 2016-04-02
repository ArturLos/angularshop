package pl.angularshop.zamowienie

import javax.persistence._

import pl.angularshop.produkt.Produkt

import scala.collection.JavaConversions._
import scala.collection._

@Entity
case class Zamowienie() {

  @Id
  @GeneratedValue
  var id: Integer = _

  @ManyToMany
  var produkty: java.util.List[Produkt] = mutable.Buffer[Produkt]()

  @OneToOne
  var daneDostawy: DaneDostawy = _
  
}
