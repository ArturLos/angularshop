package pl.angularshop.kategoria;

import pl.angularshop.produkt.Produkt;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Kategoria {
  @Id
  @GeneratedValue
  private Integer id;
  private String kod;
  private String nazwa;
  @ManyToOne
  private Kategoria rootKategoria;
  @ManyToMany(fetch= FetchType.LAZY)
  private List<Kategoria> podKategorie;
  @ManyToMany(fetch= FetchType.LAZY)
  private List<Produkt> produkt;

  public Kategoria() {
  }

  public Kategoria(String kod, String nazwa) {
    this.kod = kod;
    this.nazwa = nazwa;
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

  public Kategoria getRootKategoria() {
    return rootKategoria;
  }

  public void setRootKategoria(Kategoria rootKategoria) {
    this.rootKategoria = rootKategoria;
  }

  public List<Kategoria> getPodKategorie() {
    return podKategorie !=null ? podKategorie : new ArrayList<Kategoria>();
  }

  public void setPodKategorie(List<Kategoria> podKategorie) {
    this.podKategorie = podKategorie;
  }

  public List<Produkt> getProdukt() {
    if (produkt == null)
      produkt = new ArrayList<Produkt>();
    return produkt;
  }

  public void setProdukt(List<Produkt> produkty) {
    this.produkt = produkty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Kategoria kategoria = (Kategoria) o;

    if (!getKod().equals(kategoria.getKod())) return false;
    if (!getNazwa().equals(kategoria.getNazwa())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = getKod().hashCode();
    result = 31 * result + getNazwa().hashCode();
    return result;
  }
}
