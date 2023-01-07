package com.quanto.repositories;

import com.quanto.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByItemAndBrandAndLocalAndPriceAndType(
            String item,
            String brand,
            String local,
            double price,
            String type
    );

}
