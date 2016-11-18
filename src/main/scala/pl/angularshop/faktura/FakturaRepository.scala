package pl.angularshop.faktura

import org.springframework.data.repository.CrudRepository


trait FakturaRepository extends CrudRepository[Faktura, Integer]{

}
