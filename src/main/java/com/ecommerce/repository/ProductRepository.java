package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    @Query("SELECT p FROM Product p WHERE" +
            " p.code like ?1 OR" +
            " p.price like ?1 OR" +
            " p.discount like ?1 OR" +
            " p.stock like ?1 OR" +
            " p.name like ?1 OR" +
            " p.description like ?1 OR" +
            " p.year like ?1")
    List<Product> findBySearch(String data);
}
