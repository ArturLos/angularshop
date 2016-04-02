package pl.angularshop.zamowienie

import org.springframework.data.repository.CrudRepository


trait DaneDostawyRepository extends CrudRepository[DaneDostawy, Integer]{

}
