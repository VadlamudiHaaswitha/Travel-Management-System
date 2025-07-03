package com.gl.tms.Respository;

import com.gl.tms.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    public Hotel findByHotelName(String hotelName);
}
