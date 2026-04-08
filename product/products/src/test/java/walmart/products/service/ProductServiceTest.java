package walmart.products.service;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.util.Assert;
import walmart.products.model.Products;
import walmart.products.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void showAllTest(){

        List<Products> productList =new ArrayList<Products>();

        Products p1 = new Products();
        p1.setProductId(10);
        p1.setProductName("prd");
        productList.add(p1);

        Products p2= new Products();
        p2.setProductId(100);
        p2.setProductName("laptop");
        productList.add(p2);

        when(productRepository.findAll()).thenReturn(productList);     //

       List<Products> lists = productService.showProduct();   //   real  method calling


      // Assertions.assertEquals(productList,lists);
        Assertions.assertEquals(2,lists.size());

    }

    @Test
    public void searchProduct_with_data_test(){
        Products prod=new Products();
        prod.setProductId(10);
        prod.setProductName("Laptop");
        when(productRepository.findById(10)).thenReturn(java.util.Optional.of(prod));
        ResponseEntity<?> result=productService.searchProduct(10);

       // Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(prod,result.getBody());
    }


    @Test
    public void searchProduct_with_nodata_test(){

        when(productRepository.findById(10)).thenReturn(Optional.empty());
        ResponseEntity<?> result=productService.searchProduct(10);

        // Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("No Record Found With: 10",result.getBody());
    }


    @Test
    public void addProduct_Test(){

        Products prod=new Products();
        prod.setProductId(10);
        prod.setProductName("Laptop");

        when(productRepository.save(any())).thenReturn(prod);

        String result=productService.addProduct(prod);
        Assertions.assertEquals("Products Added Successfully..", result);

    }

    @Test
    public void deleteProduct_Test(){
        Products prod = new Products();
        prod.setProductId(10);
        prod.setProductName("Laptop");
        when(productRepository.findById(10)).thenReturn(Optional.of(prod));
        String result = productService.deleteProduct(10);
        Assertions.assertEquals("Product Deleted Successfully..", result);

    }

    @Test
    public void deleteProduct_TestWithNoData(){

        when(productRepository.findById(10)).thenReturn(Optional.empty());
        String result = productService.deleteProduct(10);
        Assertions.assertEquals("No Record Found With: 10", result);

    }

    @Test

    public void updateProduct_Test(){
        Products oldProduct = new Products();
        oldProduct.setProductId(10);
        oldProduct.setProductName("Laptop");

        Products newProduct = new Products();
        newProduct.setProductId(10);
        newProduct.setProductName("iPhone");

        when(productRepository.findById(10)).thenReturn(java.util.Optional.of(oldProduct));
        String result = productService.updateProduct(newProduct);
        Assertions.assertEquals("Product Updated Successfully..", result);

    }

    @Test

    public void updateProduct_TestWithNoData(){

            Products newProduct = new Products();
            newProduct.setProductId(10);
            newProduct.setProductName("iPhone");

            when(productRepository.findById(10)).thenReturn(java.util.Optional.empty());
            String result = productService.updateProduct(newProduct);
            Assertions.assertEquals("Product Not Found With: 10", result);

    }

}
