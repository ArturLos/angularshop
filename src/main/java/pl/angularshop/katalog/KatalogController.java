package pl.angularshop.katalog;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.angularshop.produkt.Produkt;

@RestController
@RequestMapping("katalog")
public class KatalogController {
  private static final Logger LOG = Logger.getLogger(KatalogController.class.getName());
  
  @Autowired
  private KatalogService katalogService;

  public KatalogController() {
  }
  
  @RequestMapping(value = "produkty", method = RequestMethod.GET)
  public List<Produkt> getProduktList() {
    return katalogService.getWszystkieProdukty();
  }

  @RequestMapping(value = "produkty/kategoria/{kategoriaKod}", method = RequestMethod.GET)
  public List<Produkt> getProduktyZKategorii(@PathVariable String kategoriaKod) {
    return katalogService.getProduktyZKategorii(kategoriaKod);
  }

  @RequestMapping(value = "produkty/{produktId}", method = RequestMethod.GET)
  public Produkt getProdukt(@PathVariable Integer produktId) {
    return katalogService.getProduktById(produktId);
  }

  @RequestMapping(value = "produkty", method = RequestMethod.POST)
  public void addProdukt(@RequestBody Produkt produkt) {
    katalogService.getWszystkieProdukty().add(produkt);
  }
  
}
