package pl.angularshop.zamowienie

import javax.persistence._

@Entity
case class DaneDostawy() {

  @Id
  @GeneratedValue
  var id: Integer = _

  var imie: String = _

  var nazwisko: String = _

  var adres: String = _

  @OneToOne(mappedBy = "daneDostawy", cascade = Array(CascadeType.ALL))
  var zamowienie: Zamowienie = _
}

