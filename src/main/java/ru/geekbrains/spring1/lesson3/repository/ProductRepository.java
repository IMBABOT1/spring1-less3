package ru.geekbrains.spring1.lesson3.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson3.data.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Milk", 10),
                new Product(2l, "Water", 5),
                new Product(3l, "Apples", 21),
                new Product(4l, "Bread", 50),
                new Product(5l, "Oranges", 25)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id){
        for (Product p : products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        throw new RuntimeException("Product not found id: " + id);
    }

}
