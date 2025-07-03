package com.gl.tms.Controller;

import com.gl.tms.DTO.HotelCategoryDTO;
import com.gl.tms.DTO.ResponseDTO;
import com.gl.tms.DTO.TravelPackageDTO;
import com.gl.tms.DTO.UsersDTO;
import com.gl.tms.Exception.TravelManagementSystemException;
import com.gl.tms.Service.TravelManagementSystemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tms")
@CrossOrigin
@Validated
public class TravelManagementSystemController {
    @Autowired
    private TravelManagementSystemService travelManagementSystemService;

    @PostMapping("/add-new-user")
    ResponseEntity<ResponseDTO> addNewUserAndProfile(@RequestBody @Valid UsersDTO usersDTO) throws TravelManagementSystemException {
        ResponseDTO responseDTO = travelManagementSystemService.addNewUserAndProfile(usersDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }
    @GetMapping("/fetch-user/{email}")
    ResponseEntity<UsersDTO> fetchUsersByEmail(@PathVariable @Email(message="Email should be in valid format") String email) throws TravelManagementSystemException {
        UsersDTO responseDTO = travelManagementSystemService.fetchUsersByEmail(email);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update-userName/{email}/{updatedName}")
    ResponseEntity<ResponseDTO> updateUserName(@PathVariable @Email(message="Email should be in valid format") String email, @PathVariable @NotBlank(message = "Updated name should not be null or blank!") String updatedName) throws TravelManagementSystemException {
        ResponseDTO responseDTO = travelManagementSystemService.updateUserName(email, updatedName);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete-user/{email}")
    ResponseEntity<ResponseDTO> deleteUser(@PathVariable @Email(message="Email should be in valid format") String email) throws TravelManagementSystemException {
        ResponseDTO responseDTO = travelManagementSystemService.deleteUser(email);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/add-travel-packing")
    ResponseEntity<ResponseDTO> addTravelPackage(@RequestBody @Valid TravelPackageDTO travelPackageDTO) throws TravelManagementSystemException {
        ResponseDTO responseDTO = travelManagementSystemService.addTravelPackage(travelPackageDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/fetch-available-packages/{destination}")
    ResponseEntity<TravelPackageDTO> fetchTravelPackageByDestination(@PathVariable @NotBlank(message = "destination should not be null or blank!!") String destination)  throws TravelManagementSystemException{
        TravelPackageDTO travelPackageDTO = travelManagementSystemService.fetchTravelPackageByDestination(destination);
        return new ResponseEntity<>(travelPackageDTO, HttpStatus.OK);
    }
    @PostMapping("/add-hotel-categories/{HotelName}")
    ResponseEntity<ResponseDTO> addHotelCategoriesOfHotel(@PathVariable @NotBlank(message = "destination should not be null or blank!!") String HotelName , @RequestBody @Valid HotelCategoryDTO hotelCategoryDTO) throws TravelManagementSystemException
    {
        ResponseDTO responseDTO = travelManagementSystemService.addHotelCategoriesOfHotel(HotelName, hotelCategoryDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/fetch-hotel-categories/{HotelName}")
    ResponseEntity<List<HotelCategoryDTO>> fetchHotelCategoriesOfHotel(@PathVariable @NotBlank(message = "destination should not be null or blank!!") String HotelName) throws TravelManagementSystemException {
        List<HotelCategoryDTO>hotelCategoryDTOList = travelManagementSystemService.fetchHotelCategoriesOfHotel(HotelName);
        return new ResponseEntity<>(hotelCategoryDTOList,HttpStatus.OK);

    }
//    @DeleteMapping("/delete-travel-package/{destination}")
//    ResponseEntity<ResponseDTO> deleteTravelPackage(@PathVariable String destination) {
//        ResponseDTO responseDTO = travelManagementSystemService.deleteTravelPackage(destination);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }


}
