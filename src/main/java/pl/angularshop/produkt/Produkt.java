package pl.angularshop.produkt;

import com.fasterxml.jackson.annotation.JsonInclude;
import pl.angularshop.kategoria.Kategoria;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produkt {
  
  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  private String kod;

  private String nazwa;
  
  private String krotkiOpis;
  @Column(length = 10024)
  private String opis;

  @ElementCollection
  private Set<String> obrazek = new HashSet<String>();

  @ManyToMany(mappedBy = "produkt", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
  private Set<Kategoria> kategoria = new HashSet<>();

  public Produkt() {
  }

  public Produkt(String kod, String nazwa) {
    this.kod = kod;
    this.nazwa = nazwa;
  }

  public Produkt(String kod, String nazwa, String krotkiOpis, String opis) {
    this(kod, nazwa);
    this.krotkiOpis = krotkiOpis;
    this.opis = opis;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKod() {
    return kod;
  }

  public void setKod(String kod) {
    this.kod = kod;
  }

  public String getNazwa() {
    return nazwa;
  }

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public String getKrotkiOpis() {
    return krotkiOpis;
  }

  public void setKrotkiOpis(String krotkiOpis) {
    this.krotkiOpis = krotkiOpis;
  }

  public String getOpis() {
    return opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }

  public Set<String> getObrazek() {
    return this.obrazek;
  }

  public void setObrazek(Set<String> obrazek) {
    this.obrazek = obrazek;
  }

  public Set<Kategoria> getKategoria() {
    return kategoria;
  }

  public void setKategoria(Set<Kategoria> kategoria) {
    this.kategoria = kategoria;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Produkt produkt = (Produkt) o;

    if (getKod() != null ? !getKod().equals(produkt.getKod()) : produkt.getKod() != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = getKod() != null ? getKod().hashCode() : 0;
    return result;
  }

  @Transient
  public static final String TO_STRING(Produkt produkt){
    return "Produkt{" +
      "id=" + produkt.id +
      ", kod='" + produkt.kod + '\'' +
      ", nazwa='" + produkt.nazwa + '\'' +
      ", krotkiOpis='" + produkt.krotkiOpis + '\'' +
      ", opis='" + (produkt.opis!=null ? produkt.opis.substring(0,produkt.opis.length()>20?20:produkt.opis.length()):"") + "'.." +
      '}';
  }

  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public class ProduktDto {
    public String kod;
    public String nazwa;
    public String krotkiOpis;
    public String opis;
    public Set<String> obrazek;
  }

  public ProduktDto toDto(){
    ProduktDto result = new ProduktDto();
    result.kod = getKod();
    result.nazwa = getNazwa();
    result.krotkiOpis = getKrotkiOpis();
    result.opis = getOpis();
    result.obrazek = getObrazek();
    return result;
  }

}
