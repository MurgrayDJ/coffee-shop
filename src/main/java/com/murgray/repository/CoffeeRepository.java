package com.murgray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeRepository extends JpaRepository<HotCoffeeType, Long> {
    
    @Query("SELECT h.typeId, h.coffeeType, m.milkType FROM HotCoffeeType h JOIN MilkType m ON h.milkTypeId = m.milkTypeId")
    List<Object[]> findCoffeeTypes();
}