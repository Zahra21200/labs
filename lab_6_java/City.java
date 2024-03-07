public class City {
    
        private int id;
        private String name;
        private int population;
        private String countryCode;



        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }
        public int getPopulation() {
            return population;
        }
        public String getCountryCode() {
            return countryCode;
        }
        public void setName(String name) {
            this.name = name;
        }
    
        public void setPopulation(int population) {
            this.population = population;
        }
    
        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
        
public String toString() {
    return "Country{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", population='" + population + '\'' +
            ", countryCode=" + countryCode +
            ", population=" + population +
            '}';
}
}
