package com.gl.tms.Service;

import com.gl.tms.DTO.HotelCategoryDTO;
import com.gl.tms.DTO.ResponseDTO;
import com.gl.tms.DTO.TravelPackageDTO;
import com.gl.tms.DTO.UsersDTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface TravelManagementSystemService {


    public ResponseDTO addNewUserAndProfile(UsersDTO usersDTO);
    public UsersDTO fetchUsersByEmail(String email);
    public ResponseDTO updateUserName(String email,String updatedName);
    public ResponseDTO deleteUser(String email);
    public ResponseDTO addTravelPackage(TravelPackageDTO travelPackageDTO);
    public TravelPackageDTO fetchTravelPackageByDestination(String destination);
    public ResponseDTO addHotelCategoriesOfHotel(String HotelName ,HotelCategoryDTO hotelCategoryDTO);
    public List<HotelCategoryDTO> fetchHotelCategoriesOfHotel(String HotelName);
//  public ResponseDTO deleteTravelPackage(String destination);


}
