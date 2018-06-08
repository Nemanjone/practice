package nemanja.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import nemanja.springframework.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
