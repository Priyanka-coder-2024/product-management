package walmart.products.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import walmart.products.model.Products;
import walmart.products.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void showProductTest(){
        List<Products> productList =new ArrayList<Products>();

        Products p1 = new Products();
        p1.setProductId(10);
        p1.setProductName("prd");
        productList.add(p1);

        Products p2= new Products();
        p2.setProductId(100);
        p2.setProductName("laptop");
        productList.add(p2);

        when(productService.showProduct()).thenReturn(productList);
        List<Products> lists = productController.showAllProducts();   //   real  method calling


        // Assertions.assertEquals(productList,lists);
        Assertions.assertEquals(2,lists.size());


    }


}
