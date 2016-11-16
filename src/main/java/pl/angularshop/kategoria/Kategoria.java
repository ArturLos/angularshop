package pl.angularshop.kategoria;

import com.fasterxml.jackson.annotation.JsonInclude;
import pl.angularshop.produkt.Produkt;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Kategoria {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  private String kod;
  private String nazwa;
  @ManyToOne
  private Kategoria rootKategoria;
  @ManyToMany(fetch= FetchType.LAZY)
  private List<Kategoria> podKategorie =  new ArrayList<Kategoria>();
  @ManyToMany(fetch= FetchType.LAZY)
  @JoinTable(
    name = "kategoria_produkt",
    joinColumns = {@JoinColumn(name = "kategoria_id")},
    inverseJoinColumns = {@JoinColumn(name = "produkt_id")}
  )
  private Set<Produkt> produkt = new HashSet<Produkt>();

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
    return podKategorie;
  }

  public void setPodKategorie(List<Kategoria> podKategorie) {
    this.podKategorie = podKategorie;
  }

  public Set<Produkt> getProdukt() {
    return produkt;
  }

  public void setProdukt(Set<Produkt> produkty) {
    this.produkt = produkty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Kategoria kategoria = (Kategoria) o;

    if (!getKod().equals(kategoria.getKod())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = getKod().hashCode();
    return result;
  }

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  public class KategoriaDto {
    public String kod;
    public String nazwa;
    public List<Kategoria> podKategorie;
  }

  public KategoriaDto toDto() {
    KategoriaDto result = new KategoriaDto();
    result.kod = getKod();
    result.nazwa = getNazwa();
//    result.podKategorie = getPodKategorie();
    return result;
  }

}
