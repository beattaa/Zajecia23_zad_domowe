package pl.beata.zajecia23_zad_domowe;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> productsList = new ArrayList<>();

    public ProductRepository() {
        productsList.add(new Product("Pasta do zębów", 10.50, Category.INNE));
        productsList.add(new Product("Płyn do naczyn", 6.50, Category.INNE));
        productsList.add(new Product("Ser żółty", 3.50, Category.ART_SPOŻYWCZE));
        productsList.add(new Product("Ser biały", 4.90, Category.ART_SPOŻYWCZE));
        productsList.add(new Product("Czerwone wino", 30.00, Category.ART_SPOŻYWCZE));
        productsList.add(new Product("Kubek", 5.00, Category.ART_GOSP_DOMOWEGO));
        productsList.add(new Product("Czajnik", 50.00, Category.ART_GOSP_DOMOWEGO));
    }

    public List<Product> getProducts() {
        return productsList;
    }

    public List<Product> getProductsWithCategory(String name) {
        return productsList.stream()
                .filter(product -> product.getCategory().getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void addProduct (Product product){
        productsList.add(product);
    }

}
