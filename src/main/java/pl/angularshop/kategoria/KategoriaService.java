package pl.angularshop.kategoria;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriaService {
  
  @Autowired
  private KategoriaRepository kategoriaRepository;
  
  public List<Kategoria> getWszystkieKategorie(){
    List<Kategoria> result = new ArrayList<Kategoria>();
    this.kategoriaRepository.findAll().forEach(kategoria -> result.add(kategoria));
    return result;
  }

}
