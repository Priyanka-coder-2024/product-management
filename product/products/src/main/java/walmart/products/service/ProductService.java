package walmart.products.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import walmart.products.model.Products;
import walmart.products.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Products>showProduct(){
        return productRepository.findAll();
    }

    public String addProduct(Products products){
        productRepository.save(products);
        return "Products Added Successfully..";
    }

    private Optional<Products> getProduct(int productId){
        return productRepository.findById(productId);
    }

    public String deleteProduct(int productId){
        Optional<Products> products= getProduct(productId);
        if(products.isPresent()) {
            productRepository.delete(products.get());
            return "Product Deleted Successfully..";
        }else{
            return "No Record Found With: "+productId;
        }
    }

    public ResponseEntity<?> searchProduct(int productId){
        Optional<Products> products= getProduct(productId);
        if(products.isPresent()) {
            return ResponseEntity.ok(products.get());
        }else{
            return ResponseEntity.ok("No Record Found With: "+productId);

        }

    }

}
