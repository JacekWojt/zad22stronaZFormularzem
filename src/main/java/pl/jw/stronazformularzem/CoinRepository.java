package pl.jw.stronazformularzem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoinRepository {

    private List<Coin> coins;

    public CoinRepository() {
        coins = new ArrayList<>();
        coins.add(new Coin("Krugerrand", "Południowoafrykańska moneta wybijana od 1967 roku.", "/coinphoto/krugerand_f.JPG", 9200));
        coins.add(new Coin("Liść Klonowy", "Kanadyjska moneta, która jest uznawana za najlepiej zabezpieczoną przed podrobieniem.", "/coinphoto/maple_leaf_f.JPG", 9350));
        coins.add(new Coin("Orzeł Amerykański", "Amerykańska moneta, posiada status oficjalnego środka płątniczego w USA.", "/coinphoto/american_eagle_f.JPG", 9250));
    }

    public Coin findByName(String name) {
        for (Coin coin : coins) {
            if (coin.getName().equals(name)) {
                return coin;
            }
        }
        return null;
    }
}
