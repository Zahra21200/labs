import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class world {

    public static void main(String[] args) {
        List<Country> countries = readCountriesFromFile("Countries.csv");
        List<City> cities = readCitiesFromFile("cities.csv");

        Map<String, City> highestPopulatedCitiesByCountry = findHighestPopulatedCityByCountry(countries, cities);
        System.out.println("Highest populated city of each country:");
        highestPopulatedCitiesByCountry.forEach((countryCode, city) ->
                System.out.println(countryCode + ": " + city.getName() + " - Population: " + city.getPopulation()));

        Map<String, Country> mostPopulatedCountriesByContinent = findMostPopulatedCountryByContinent(countries);
        System.out.println("\nMost populated country of each continent:");
        mostPopulatedCountriesByContinent.forEach((continent, country) ->
                System.out.println(continent + ": " + country.getName() + " - Population: " + country.getPopulation()));

        City highestPopulatedCapital = findHighestPopulatedCapital(countries, cities);
        System.out.println("\nHighest populated capital city:");
        System.out.println(highestPopulatedCapital.getName() + " - Population: " + highestPopulatedCapital.getPopulation());
    }

    private static List<Country> readCountriesFromFile(String fileName) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Country country = new Country();
                country.setCode(values[0]);
                country.setName(values[1]);
                country.setContinent(values[2]);
                country.setSurfaceArea(Double.parseDouble(values[3]));
                country.setPopulation((int) Double.parseDouble(values[4]));
                country.setGnp(Double.parseDouble(values[5]));
                country.setCapital((int) Double.parseDouble(values[6]));
                countries.add(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    private static List<City> readCitiesFromFile(String fileName) {
        List<City> cities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                City city = new City();
                city.setId(Integer.parseInt(values[0]));
                city.setName(values[1]);
                city.setPopulation(Integer.parseInt(values[2]));
                city.setCountryCode(values[3]);
                cities.add(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static Map<String, City> findHighestPopulatedCityByCountry(List<Country> countries, List<City> cities) {
        Map<String, City> highestPopulatedCities = new HashMap<>();
        for (Country country : countries) {
            List<City> citiesInCountry = cities.stream()
                    .filter(city -> city.getCountryCode().equals(country.getCode()))
                    .collect(Collectors.toList());

            City highestPopulatedCity = citiesInCountry.stream()
                    .max(Comparator.comparingInt(City::getPopulation))
                    .orElse(null);

            if (highestPopulatedCity != null) {
                highestPopulatedCities.put(country.getCode(), highestPopulatedCity);
            }
        }
        return highestPopulatedCities;
    }

    private static Map<String, Country> findMostPopulatedCountryByContinent(List<Country> countries) {
        Map<String, Country> mostPopulatedCountries = new HashMap<>();
        for (Country country : countries) {
            mostPopulatedCountries.merge(country.getContinent(), country,
                    (existing, replacement) -> existing.getPopulation() > replacement.getPopulation() ? existing : replacement);
        }
        return mostPopulatedCountries;
    }

    private static City findHighestPopulatedCapital(List<Country> countries, List<City> cities) {
        List<City> capitalCities = cities.stream()
                .filter(city -> countries.stream()
                        .anyMatch(country -> country.getCapital() == city.getId()))
                .collect(Collectors.toList());

        return capitalCities.stream().max(Comparator.comparingInt(City::getPopulation)).orElse(null);
    }
}
