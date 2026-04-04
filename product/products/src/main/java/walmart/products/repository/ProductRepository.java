package walmart.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import walmart.products.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {




}
