package pl.angularshop.kategoria;

import org.springframework.data.repository.CrudRepository;

public interface KategoriaRepository extends CrudRepository<Kategoria, Integer>{

    Kategoria findByKod(String kod);

}
