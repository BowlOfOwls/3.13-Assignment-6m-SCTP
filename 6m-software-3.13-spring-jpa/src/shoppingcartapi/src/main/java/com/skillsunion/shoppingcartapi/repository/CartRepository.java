package com.skillsunion.shoppingcartapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillsunion.shoppingcartapi.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
   
}
