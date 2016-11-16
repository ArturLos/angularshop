package pl.angularshop.kategoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriaRepository extends JpaRepository<Kategoria, Integer> {

    Kategoria findByKod(String kod);

}
