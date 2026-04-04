package walmart.products.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import walmart.products.model.Products;
import walmart.products.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService=productService;
    }

    @GetMapping("/showProduct")
    public List<Products> showAllProducts(){
        return productService.showProduct();
    }

    @PostMapping("/addProducts")
    public String addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping("/searchProduct/{productId}")
    public ResponseEntity<?>searchProduct(@PathVariable int productId){
        return productService.searchProduct(productId);
    }

}
