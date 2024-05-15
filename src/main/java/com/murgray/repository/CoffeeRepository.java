package com.murgray.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murgray.entity.HotCoffeeType;

public interface CoffeeRepository extends JpaRepository<HotCoffeeType, Long> {
    
    @Query("SELECT h.typeId, h.coffeeType, m.milkType FROM HotCoffeeType h JOIN MilkType m ON h.milkTypeId = m.milkTypeId")
    List<Object[]> findCoffeeTypes();
}