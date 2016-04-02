package pl.angularshop.produkt;

import pl.angularshop.kategoria.Kategoria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Produkt {
  
  @Id
  @GeneratedValue
  private Integer id;
  
  private String kod;

  private String nazwa;
  
  private String krotkiOpis;
  @Column(length = 5024)
  private String opis;
  
  @ElementCollection
  private Set<String> obrazek;

  @Transient
  @ManyToMany(mappedBy = "produkt",fetch= FetchType.LAZY)
  private List<Kategoria> kategoria;

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
    if(obrazek == null)
      this.obrazek = new HashSet<String>();
    return this.obrazek;
  }

  public void setObrazek(Set<String> obrazek) {
    this.obrazek = obrazek;
  }

  public List<Kategoria> getKategoria() {
    if (kategoria == null)
      kategoria = new ArrayList<Kategoria>();
    return kategoria;
  }

  public void setKategoria(List<Kategoria> kategoria) {
    this.kategoria = kategoria;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Produkt produkt = (Produkt) o;

    if (getKod() != null ? !getKod().equals(produkt.getKod()) : produkt.getKod() != null) return false;
    if (getNazwa() != null ? !getNazwa().equals(produkt.getNazwa()) : produkt.getNazwa() != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = getKod() != null ? getKod().hashCode() : 0;
    result = 31 * result + (getNazwa() != null ? getNazwa().hashCode() : 0);
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
      ", obrazek=[" + produkt.getObrazek().stream().collect(Collectors.joining(", ")) +"}"+
//      ", kategoria=[" + produkt.getKategoria().stream().map(Kategoria::getKod).collect(Collectors.joining(", ")) +"}"+
      '}';
  }

  //serializable zrobić hashCode na odpowiednich polach i equals
}
