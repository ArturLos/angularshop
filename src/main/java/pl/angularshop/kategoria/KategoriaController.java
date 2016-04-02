package pl.angularshop.kategoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kategoria")
public class KategoriaController {
  
  @Autowired
  private KategoriaService kategoriaService;
  
  @RequestMapping(value = "wszystkie", method = RequestMethod.GET)
  public List<Kategoria> getKategoriaList(){
    return kategoriaService.getWszystkieKategorie();
  }
}
