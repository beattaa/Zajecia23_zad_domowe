package pl.beata.zajecia23_zad_domowe;

import java.util.Arrays;

public enum Category {
    ART_SPOŻYWCZE("spozywcze"),
    ART_GOSP_DOMOWEGO("domowe"),
    INNE("inne");

    String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category getCategoryByTextCode(String txt) {
        return Arrays.stream(Category.values())
                .filter(x -> x.getName().equalsIgnoreCase(txt))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Category '" + txt + "' was not found."));
    }
}
