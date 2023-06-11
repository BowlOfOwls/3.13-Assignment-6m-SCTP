package com.skillsunion.shoppingcartapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsunion.shoppingcartapi.entity.Cart;
import com.skillsunion.shoppingcartapi.repository.CartRepository;
import com.skillsunion.shoppingcartapi.repository.CatalogueRepository;

/*
    Assignment:
    - Apply @RestController to the class.
    - Apply @GetMapping and @PostMapping to the methods.
    - Apply @PathVariable to the method parameter of get(int).

    Test:
    - Use a client HTTP Tool like YARC to consume the API you have just created.
    E.g. https://chrome.google.com/webstore/detail/yet-another-rest-client/ehafadccdcdedbhcbddihehiodgcddpl?hl=en
*/

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepo;
    
    @GetMapping("/carts")
    public ResponseEntity<List<Cart>>list(){
        List<Cart> carts = cartRepo.findAll();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<Optional<Cart>> get(@PathVariable int id){
        Optional<Cart> result = (Optional<Cart>) cartRepo.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/carts")
    public ResponseEntity<Cart> create(@RequestBody Cart cart){
        Cart createdCart = cartRepo.save(cart);
        return ResponseEntity.ok(createdCart);
    }
}