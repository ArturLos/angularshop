package pl.angularshop.faktura

import javax.persistence._

import pl.angularshop.zamowienie.Zamowienie

@Entity
case class Faktura() {

  @Id
  @GeneratedValue
  var id: Integer = _

  @OneToOne(cascade = Array(CascadeType.ALL))
  var zamowienie: Zamowienie = _

}
