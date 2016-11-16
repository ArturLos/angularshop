package pl.angularshop.katalog;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.angularshop.produkt.Produkt;

@RestController
@RequestMapping("katalog")
public class KatalogController {
  private static final Logger LOG = Logger.getLogger(KatalogController.class.getName());
  
  @Autowired
  private KatalogService katalogService;

  public KatalogController() {
  }
  
  @RequestMapping(value = {"produkty"}, method = RequestMethod.GET)
  public List<Produkt.ProduktDto> getProduktList(@RequestParam(required = false) Integer page) {
    return katalogService.getWszystkieProduktyByPage(page!=null?page-1:0).stream()
      .map(produkt -> produkt.toDto())
      .collect(Collectors.toList());
  }

  @RequestMapping(value = "produkty/kategoria/{kategoriaKod}", method = RequestMethod.GET)
  public List<Produkt.ProduktDto> getProduktyZKategorii(@PathVariable String kategoriaKod, @RequestParam(required = false) Integer page) {
    return katalogService.getProduktyZKategoriiByPage(kategoriaKod, page!=null?page-1:0).stream()
      .map(produkt -> produkt.toDto())
      .collect(Collectors.toList());
  }

  @RequestMapping(value = "produkty/{produktKod}", method = RequestMethod.GET)
  public Produkt.ProduktDto getProdukt(@PathVariable String produktKod) {
    Produkt.ProduktDto result = null;
    Produkt produkt = katalogService.getProduktByKod(produktKod);
    if(produkt!=null) {
      result = produkt.toDto();
    }
    return result;
  }

  @RequestMapping(value = "produkty", method = RequestMethod.POST)
  public void addProdukt(@RequestBody Produkt produkt) {
    katalogService.getWszystkieProdukty().add(produkt);
  }
  
}
