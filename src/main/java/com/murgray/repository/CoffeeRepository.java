package com.murgray.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murgray.entity.HotCoffee;

public interface CoffeeRepository extends JpaRepository<HotCoffee, Long> {
    
    @Query("SELECT hc.coffeeType, hc.milkType.milkType, hc.milkTexture.texture, " +
        "CASE WHEN hc.hasCoffee = TRUE THEN 'true' ELSE 'false' END AS hasCoffee, " +
        "CASE WHEN hc.hasEspresso = TRUE THEN 'true' ELSE 'false' END AS hasEspresso, " +
        "CASE WHEN hc.hasOtherIngredients = TRUE THEN 'true' ELSE 'false' END AS hasOtherIngredients " +
        "FROM HotCoffee hc WHERE hc.milkType.milkType <> 'no milk'")
    List<Object[]> findCoffeeTypes(); 

   
}