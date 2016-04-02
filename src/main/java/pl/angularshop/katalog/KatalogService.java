package pl.angularshop.katalog;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.angularshop.kategoria.Kategoria;
import pl.angularshop.kategoria.KategoriaRepository;
import pl.angularshop.produkt.Produkt;
import pl.angularshop.produkt.ProduktRepository;

@Service
public class KatalogService {

  @Autowired
  private ProduktRepository produktRepository;

  @Autowired
  private KategoriaRepository kategoriaRepository;

  public List<Produkt> getWszystkieProdukty() {
    List<Produkt> result = new ArrayList<>();
    this.produktRepository.findAll().forEach(produkt -> result.add(produkt));
    return result;
  }

  public List<Produkt> getProduktyZKategorii(String kategoriaKod){
    List<Produkt> result = new ArrayList<Produkt>();
    result.addAll(
      kategoriaRepository.findByKod(kategoriaKod).getProdukt()
    );
    return result;
  }

  public Produkt getProduktById(Integer id) {
    return this.produktRepository.findOne(id);
  }

  public void saveProdukt(Produkt produkt) {
    this.produktRepository.save(produkt);
    if (produkt.getKategoria().size()>0) {
      for(Kategoria kategoria: produkt.getKategoria()) {
        Kategoria repoKategoria = this.kategoriaRepository.findByKod(kategoria.getKod());
        if(repoKategoria!=null) {
          repoKategoria.getProdukt().add(produkt);
          this.kategoriaRepository.save(repoKategoria);
        }else{
          kategoria.getProdukt().add(produkt);
          this.kategoriaRepository.save(kategoria);
        }

      }
    }

  }
}
