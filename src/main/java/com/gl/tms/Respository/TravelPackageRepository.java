package com.gl.tms.Respository;

import com.gl.tms.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Integer> {

    TravelPackage findByDestinationIgnoreCase(String destination);

}
