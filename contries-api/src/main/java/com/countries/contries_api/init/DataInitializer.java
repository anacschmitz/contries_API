package com.countries.contries_api.init;

import com.countries.contries_api.entity.City;
import com.countries.contries_api.entity.Country;
import com.countries.contries_api.repository.CityRepository;
import com.countries.contries_api.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public DataInitializer(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) {
        // Guard against re-seeding on every restart when using a persistent database (e.g. Postgres in prod profile).
        // With H2 in-memory (dev profile) the database is recreated on each startup anyway, so count() is always 0.
        if (countryRepository.count() > 0) {
            return;
        }

        Country brazil = countryRepository.save(new Country("Brazil"));
        Country usa = countryRepository.save(new Country("United States"));
        Country portugal = countryRepository.save(new Country("Portugal"));
        Country japan = countryRepository.save(new Country("Japan"));
        Country luxembourg = countryRepository.save(new Country("Luxembourg"));

        // Brazil (25 cities)
        cityRepository.save(new City("Sao Paulo", brazil, 1521L, 12300000L, "01310", "The largest city in Brazil and a major financial hub."));
        cityRepository.save(new City("Rio de Janeiro", brazil, 1200L, 6700000L, "20040", "Famous for its beaches and Christ the Redeemer statue."));
        cityRepository.save(new City("Brasilia", brazil, 5802L, 3100000L, "70040", "The federal capital of Brazil."));
        cityRepository.save(new City("Belo Horizonte", brazil, 331L, 2500000L, "30130", "Known for its modernist architecture."));
        cityRepository.save(new City("Curitiba", brazil, 435L, 1900000L, "80010", "Recognized for urban planning and green spaces."));
        cityRepository.save(new City("Salvador", brazil, 693L, 2900000L, "40010", "Capital of Bahia, known for its Afro-Brazilian culture."));
        cityRepository.save(new City("Fortaleza", brazil, 314L, 2700000L, "60010", "A major coastal city known for its beaches."));
        cityRepository.save(new City("Recife", brazil, 218L, 1650000L, "50010", "Known as the 'Venice of Brazil' for its rivers and bridges."));
        cityRepository.save(new City("Porto Alegre", brazil, 497L, 1490000L, "90010", "Capital of Rio Grande do Sul, known for its gaucho culture."));
        cityRepository.save(new City("Manaus", brazil, 11401L, 2200000L, "69010", "Gateway to the Amazon rainforest."));
        cityRepository.save(new City("Belem", brazil, 1059L, 1500000L, "66010", "A historic port city at the mouth of the Amazon."));
        cityRepository.save(new City("Goiania", brazil, 739L, 1550000L, "74010", "A planned city known for its wide avenues and parks."));
        cityRepository.save(new City("Guarulhos", brazil, 318L, 1400000L, "07010", "Home to Brazil's busiest international airport."));
        cityRepository.save(new City("Campinas", brazil, 794L, 1220000L, "13010", "A major hub for technology and industry."));
        cityRepository.save(new City("Sao Luis", brazil, 834L, 1100000L, "65010", "Known for its colonial Portuguese architecture."));
        cityRepository.save(new City("Sao Goncalo", brazil, 249L, 1080000L, "24410", "Part of the Rio de Janeiro metropolitan area."));
        cityRepository.save(new City("Maceio", brazil, 511L, 1020000L, "57010", "Known for its clear-water lagoons and beaches."));
        cityRepository.save(new City("Duque de Caxias", brazil, 464L, 920000L, "25010", "An industrial city in the Rio de Janeiro metro area."));
        cityRepository.save(new City("Natal", brazil, 167L, 890000L, "59010", "Known for its sand dunes and coastal scenery."));
        cityRepository.save(new City("Teresina", brazil, 1392L, 870000L, "64010", "Capital of Piaui, located between two rivers."));
        cityRepository.save(new City("Campo Grande", brazil, 8093L, 900000L, "79010", "Gateway to the Pantanal wetlands."));
        cityRepository.save(new City("Nova Iguacu", brazil, 524L, 810000L, "26010", "One of the largest cities in the Baixada Fluminense."));
        cityRepository.save(new City("Sao Bernardo do Campo", brazil, 409L, 840000L, "09710", "A major center of the automotive industry."));
        cityRepository.save(new City("Joao Pessoa", brazil, 211L, 825000L, "58010", "Known for having one of the largest urban forests in the world."));
        cityRepository.save(new City("Santo Andre", brazil, 175L, 720000L, "09010", "Part of the ABC industrial region of Sao Paulo."));

        // Luxembourg (25 cities/communes)
        cityRepository.save(new City("Luxembourg City", luxembourg, 51L, 128000L, "1000", "The capital and largest city, a major EU financial center."));
        cityRepository.save(new City("Esch-sur-Alzette", luxembourg, 15L, 36000L, "4000", "The second-largest city, known for its industrial and mining heritage."));
        cityRepository.save(new City("Differdange", luxembourg, 22L, 28000L, "4500", "A former steel town in the southwest, near the French border."));
        cityRepository.save(new City("Dudelange", luxembourg, 22L, 21000L, "3400", "Known for its steel industry history and cultural centers."));
        cityRepository.save(new City("Ettelbruck", luxembourg, 11L, 9500L, "9000", "A market town in central Luxembourg, known as the 'Gateway to the North'."));
        cityRepository.save(new City("Diekirch", luxembourg, 11L, 7200L, "9200", "Known for its brewery and the Ardennes battle museum."));
        cityRepository.save(new City("Wiltz", luxembourg, 46L, 5700L, "9500", "A hilltop town in the north, known for its festivals."));
        cityRepository.save(new City("Echternach", luxembourg, 25L, 5900L, "6400", "Luxembourg's oldest town, known for its abbey."));
        cityRepository.save(new City("Rumelange", luxembourg, 8L, 6000L, "3670", "A former mining town near the French border."));
        cityRepository.save(new City("Grevenmacher", luxembourg, 11L, 5300L, "6700", "Known for its vineyards along the Moselle river."));
        cityRepository.save(new City("Remich", luxembourg, 10L, 3800L, "5500", "A resort town on the Moselle, known for wine tourism."));
        cityRepository.save(new City("Mersch", luxembourg, 26L, 9700L, "7500", "Considered the geographical center of Luxembourg."));
        cityRepository.save(new City("Bettembourg", luxembourg, 20L, 11000L, "3200", "Known for its rail freight terminal and animal park."));
        cityRepository.save(new City("Sanem", luxembourg, 22L, 16000L, "4480", "A commune in the southwest, part of the mining basin."));
        cityRepository.save(new City("Schifflange", luxembourg, 11L, 10500L, "3800", "A former steelworks town near Esch-sur-Alzette."));
        cityRepository.save(new City("Petange", luxembourg, 19L, 20000L, "4700", "A commune on the border with Belgium and France."));
        cityRepository.save(new City("Bascharage", luxembourg, 11L, 7500L, "4900", "Known for its former brewery, now a shopping center."));
        cityRepository.save(new City("Strassen", luxembourg, 8L, 9700L, "8001", "A residential and commercial commune near the capital."));
        cityRepository.save(new City("Bertrange", luxembourg, 11L, 8200L, "8001", "Home to one of the largest shopping centers in the country."));
        cityRepository.save(new City("Hesperange", luxembourg, 21L, 14500L, "5801", "A green commune bordering Luxembourg City."));
        cityRepository.save(new City("Mamer", luxembourg, 17L, 8600L, "8201", "Known for its castle ruins and lake."));
        cityRepository.save(new City("Dippach", luxembourg, 11L, 4300L, "4901", "A small commune in the southwest of the country."));
        cityRepository.save(new City("Kayl", luxembourg, 13L, 8800L, "3601", "A former mining commune in the south."));
        cityRepository.save(new City("Wormeldange", luxembourg, 22L, 3100L, "5401", "Known as the wine capital of Luxembourg."));
        cityRepository.save(new City("Vianden", luxembourg, 12L, 1900L, "9401", "A picturesque town known for its medieval castle."));

        // United States
        cityRepository.save(new City("New York City", usa, 783L, 8300000L, "10001", "The most populous city in the United States."));
        cityRepository.save(new City("Los Angeles", usa, 1302L, 3900000L, "90001", "Major center of the entertainment industry."));
        cityRepository.save(new City("Chicago", usa, 606L, 2700000L, "60601", "Known for its architecture and skyline."));
        cityRepository.save(new City("Houston", usa, 1651L, 2300000L, "77001", "A leading hub for the energy industry."));
        cityRepository.save(new City("Miami", usa, 143L, 460000L, "33101", "Known for its beaches and vibrant nightlife."));

        // Portugal
        cityRepository.save(new City("Lisbon", portugal, 100L, 545000L, "10011", "Capital and largest city of Portugal."));
        cityRepository.save(new City("Porto", portugal, 41L, 237000L, "40001", "Known for its port wine and riverside district."));
        cityRepository.save(new City("Braga", portugal, 183L, 193000L, "47001", "One of the oldest cities in Portugal."));
        cityRepository.save(new City("Coimbra", portugal, 320L, 143000L, "30001", "Home to one of the oldest universities in Europe."));
        cityRepository.save(new City("Faro", portugal, 202L, 65000L, "80001", "Gateway to the Algarve region."));

        // Japan
        cityRepository.save(new City("Tokyo", japan, 2194L, 13900000L, "1001", "Capital of Japan and one of the world's most populous cities."));
        cityRepository.save(new City("Osaka", japan, 225L, 2700000L, "5301", "Known for its modern architecture and street food."));
        cityRepository.save(new City("Kyoto", japan, 828L, 1460000L, "6006", "Famous for its classical Buddhist temples and gardens."));
        cityRepository.save(new City("Yokohama", japan, 437L, 3750000L, "2201", "Japan's second-largest city, known for its port."));
        cityRepository.save(new City("Nagoya", japan, 326L, 2320000L, "4601", "A major industrial and manufacturing center."));
    }
}
