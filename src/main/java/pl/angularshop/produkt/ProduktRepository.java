package pl.angularshop.produkt;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.angularshop.kategoria.Kategoria;

import java.util.List;

public interface ProduktRepository extends JpaRepository<Produkt, Integer> {
  Produkt findByKod(String kod);

  List<Produkt> findByKategoria(Kategoria kategoria, Pageable pagable);
}
