package com.murgray.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murgray.entity.HotCoffee;

public interface CoffeeRepository extends JpaRepository<HotCoffee, Long> {
    
    // @Query("SELECT hc.coffeeType, mt.milkType, mxt.texture, " +
    //     "CASE WHEN hc.hasCoffee = TRUE THEN 'true' ELSE 'false' END AS hasCoffee, " +
    //     "CASE WHEN hc.hasEspresso = TRUE THEN 'true' ELSE 'false' END AS hasEspresso, " +
    //     "CASE WHEN hc.hasOtherIngredients = TRUE THEN 'true' ELSE 'false' END AS hasOtherIngredients " +
    //     "FROM HotCoffee hc " +
    //     "INNER JOIN hc.milkType mt " +
    //     "INNER JOIN hc.milkTexture mxt " +
    //     "WHERE mt.milkType <> 'no milk'")
    // List<Object[]> findCoffeeTypes(); 

    @Query("SELECT hc FROM HotCoffee hc JOIN FETCH hc.milkType JOIN FETCH hc.milkTexture")
    List<HotCoffee> findAllHotCoffee();
   
}