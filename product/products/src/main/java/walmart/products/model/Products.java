package walmart.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products {

    @Id
    private int productId;
    private String productName;
    private float productPrice;
    private String productDescription;

}
