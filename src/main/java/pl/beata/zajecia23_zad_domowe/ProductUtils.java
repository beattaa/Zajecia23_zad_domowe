package pl.beata.zajecia23_zad_domowe;

import java.util.List;

public class ProductUtils {

    public static double getSumOfProductsPrices(List<Product> productsList){
        return productsList.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();
    }
}
