package pl.beata.zajecia23_zad_domowe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("categories", Category.values());
        return "index";
    }

    @GetMapping("/allProducts")
    public String allProducts(Model model) {
        model.addAttribute("products", productRepository.getProducts());
        model.addAttribute("category", "");
        return "allProducts";
    }

    @GetMapping("/lista")
    public String home(Model model, @RequestParam(name = "kategoria") String category) {
        model.addAttribute("products", productRepository.getProductsWithCategory(category));
        model.addAttribute("category", category);
        model.addAttribute("priceSum", ProductUtils.getSumOfProductsPrices(productRepository.getProductsWithCategory(category)));
        return "allProducts";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam(required = true) String name, @RequestParam(required = true) double price, @RequestParam(required = true) Category category) {
            productRepository.addProduct(new Product(name, price,category));
        return "redirect:/allProducts";
    }

}
