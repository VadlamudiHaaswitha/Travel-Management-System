package com.gl.tms.Respository;

import com.gl.tms.entity.Hotel;
import com.gl.tms.entity.HotelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelCategoryRepository extends JpaRepository<HotelCategory, Integer> {

    public List<HotelCategory> findByHotel(Hotel hotelName);
}
