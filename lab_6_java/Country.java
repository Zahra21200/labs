public class Country {
private String code;
private String name;
private String continent;
private Double surfaceArea;
private int population;
private Double gnp;
private int capital;


public void setCode(String code) {
    this.code = code;
}

public void setName(String name) {
    this.name = name;
}

public void setContinent(String continent) {
    this.continent = continent;
}

public void setSurfaceArea(Double surfaceArea) {
    this.surfaceArea = surfaceArea;
}

public void setPopulation(int population) {
    this.population = population;
}

public void setGnp(Double gnp) {
    this.gnp = gnp;
}
public String getName() {
    return name;
}
public int getPopulation() {
    return population;
}
public String getCode() {
    return code;
}
public String getContinent() {
    return continent;
}
public int getCapital() {
    return capital;
}
public void setCapital(int capital) {
    this.capital = capital;
}

public String toString() {
    return "Country{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", continent='" + continent + '\'' +
            ", surfaceArea=" + surfaceArea +
            ", population=" + population +
            ", gnp=" + gnp +
            ", capital=" + capital +
            '}';
}
}
