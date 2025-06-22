package com.example.InstaRide.repository;

import com.example.InstaRide.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabRepository extends JpaRepository<Cab, Integer> {

    @Query("select c from Cab c where c.available = true order by rand() limit 1")
    Cab getAvailableCabRandom();
}
