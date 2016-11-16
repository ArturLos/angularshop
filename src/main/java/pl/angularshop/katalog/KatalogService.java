package pl.angularshop.katalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.angularshop.kategoria.Kategoria;
import pl.angularshop.kategoria.KategoriaRepository;
import pl.angularshop.produkt.Produkt;
import pl.angularshop.produkt.ProduktRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public List<Produkt> getWszystkieProduktyByPage(Integer page) {
    List<Produkt> result = new ArrayList<>();
    this.produktRepository.findAll(new ProduktPagination(page)).forEach(produkt -> result.add(produkt));
    return result;
  }

  private class ProduktPagination extends PageRequest {
    public ProduktPagination(int page) {
      super(page, 10, Sort.Direction.ASC, "nazwa");
    }
  }

  public List<Produkt> getProduktyZKategorii(String kategoriaKod){
    List<Produkt> result = new ArrayList<Produkt>();
    result.addAll(
      kategoriaRepository.findByKod(kategoriaKod).getProdukt()
    );
    return result;
  }

  public List<Produkt> getProduktyZKategoriiByPage(String kategoriaKod, Integer page){
    List<Produkt> result = new ArrayList<Produkt>();
    Kategoria kategoria = kategoriaRepository.findByKod(kategoriaKod);
    result.addAll(
      produktRepository.findByKategoria(kategoria, new ProduktPagination(page))
    );
    return result;
  }

  public Produkt getProduktById(Integer id) {
    return this.produktRepository.findOne(id);
  }

  public Produkt getProduktByKod(String produktKod) {
    return this.produktRepository.findByKod(produktKod);
  }

  public void saveProdukt(Produkt produkt) {
    Set<Kategoria> kategorieProduktu = new HashSet<Kategoria>();
    Set<Kategoria> kategorieInput = produkt.getKategoria();
    Produkt produktDb = getProduktByKod(produkt.getKod());
    if(produktDb!=null){ produkt = produktDb; }
    if (kategorieInput.size()>0) {
      for(Kategoria kategoria: kategorieInput) {
        Kategoria repoKategoria = this.kategoriaRepository.findByKod(kategoria.getKod());
        if(repoKategoria!=null) {
          repoKategoria.getProdukt().add(produkt);
          kategorieProduktu.add(repoKategoria);
        }else{
          kategoria.getProdukt().add(produkt);
          kategorieProduktu.add(kategoria);
        }
      }
    }
    produkt.setKategoria(kategorieProduktu);
    this.produktRepository.save(produkt);
  }


}