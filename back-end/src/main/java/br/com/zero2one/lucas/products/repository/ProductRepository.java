package br.com.zero2one.lucas.products.repository;

import br.com.zero2one.lucas.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, String> {

}
