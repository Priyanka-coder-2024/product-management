package walmart.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    private int productId;
    private String productName;
    private float productPrice;
    private String productDescription;

}
