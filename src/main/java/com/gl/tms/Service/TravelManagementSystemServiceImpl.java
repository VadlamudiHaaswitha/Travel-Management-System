package com.gl.tms.Service;

import com.gl.tms.DTO.*;
import com.gl.tms.Exception.TravelManagementSystemException;
import com.gl.tms.Respository.*;
import com.gl.tms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelManagementSystemServiceImpl implements TravelManagementSystemService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelCategoryRepository hotelCategoryRepository;
    @Autowired
    private TravelPackageRepository travelPackageRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public ResponseDTO addNewUserAndProfile(UsersDTO usersDTO) throws TravelManagementSystemException {
        Users user = userRepository.findByEmail(usersDTO.getEmail());
        if (user != null) {
            throw new TravelManagementSystemException("user already exists!");
        }

        Users users = new Users();
        users.setUserName(usersDTO.getUserName());
        users.setPassword(usersDTO.getPassword());
        users.setEmail(usersDTO.getEmail());

        UserProfile userProfile = new UserProfile();
        userProfile.setFullName(usersDTO.getUserProfileDTO().getFullName());
        userProfile.setPhoneNumber(usersDTO.getUserProfileDTO().getPhoneNumber());
        userProfile.setAddress(usersDTO.getUserProfileDTO().getAddress());
        users.setUserProfile(userProfile);
        userRepository.save(users);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("User added successfully!");
        return responseDTO;


    }

    @Override
    public UsersDTO fetchUsersByEmail(String email) throws TravelManagementSystemException {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new TravelManagementSystemException("user doesn't exist!");
        }
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserId(user.getUserId());
        usersDTO.setUserName(user.getUserName());
        usersDTO.setPassword(user.getPassword());
        usersDTO.setEmail(user.getEmail());

        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setProfileId(user.getUserProfile().getProfileId());
        userProfileDTO.setFullName(user.getUserProfile().getFullName());
        userProfileDTO.setPhoneNumber(user.getUserProfile().getPhoneNumber());
        userProfileDTO.setAddress(user.getUserProfile().getAddress());
        usersDTO.setUserProfileDTO(userProfileDTO);
        return usersDTO;
    }

    @Override
    public ResponseDTO updateUserName(String email, String updatedName) throws TravelManagementSystemException{
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new TravelManagementSystemException("user doesn't exist!");
        }
        user.setUserName(updatedName);
        userRepository.save(user);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("User updated successfully!");
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteUser(String email) throws TravelManagementSystemException{
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new TravelManagementSystemException("user doesn't exist!");
        }

        userRepository.delete(user);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("User deleted successfully!");
        return responseDTO;
    }

    @Override
    public ResponseDTO addTravelPackage(TravelPackageDTO travelPackageDTO)throws TravelManagementSystemException {
        TravelPackage travelPackage = travelPackageRepository.findByDestinationIgnoreCase(travelPackageDTO.getDestination());
        if (travelPackage != null) {
            throw new TravelManagementSystemException("travelPackage doesn't exist!");
        }

         travelPackage = new TravelPackage();
        travelPackage.setPackageName(travelPackageDTO.getPackageName());
        travelPackage.setDestination(travelPackageDTO.getDestination());
        travelPackage.setDurationDays(travelPackageDTO.getDurationDays());
        travelPackage.setPrice(travelPackageDTO.getPrice());
        travelPackage.setDescription(travelPackageDTO.getDescription());

        List<Hotel> hotelList = new ArrayList<>();
        for(HotelDTO hotelDTO: travelPackageDTO.getHotelsDTO()){
            Hotel hotel = new Hotel();
            hotel.setHotelName(hotelDTO.getHotelName());
            hotel.setHotelLocation(hotelDTO.getHotelLocation());
            hotel.setPricePerNight(hotelDTO.getPricePerNight());
            hotelList.add(hotel);
        }
        travelPackage.setHotels(hotelList);
        travelPackageRepository.save(travelPackage);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("TravelPackage added successfully!");
        return responseDTO;
    }

    @Override
    public TravelPackageDTO fetchTravelPackageByDestination(String destination) throws TravelManagementSystemException {

        TravelPackage travelPackage = travelPackageRepository.findByDestinationIgnoreCase(destination);
        if (travelPackage == null) {
            throw new TravelManagementSystemException("travelPackage doesn't exist!");
        }

        TravelPackageDTO travelPackageDTO = new TravelPackageDTO();
        travelPackageDTO.setPackageId(travelPackage.getPackageId());
        travelPackageDTO.setPackageName(travelPackage.getPackageName());
        travelPackageDTO.setDestination(travelPackage.getDestination());
        travelPackageDTO.setDurationDays(travelPackage.getDurationDays());
        travelPackageDTO.setPrice(travelPackage.getPrice());
        travelPackageDTO.setDescription(travelPackage.getDescription());

        List<HotelDTO> hotelListDTO = new ArrayList<>();

        for(Hotel hotel: travelPackage.getHotels()){
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setHotelId (hotel.getHotelId());
            hotelDTO.setHotelName(hotel.getHotelName());
            hotelDTO.setHotelLocation(hotel.getHotelLocation());
            hotelDTO.setPricePerNight(hotel.getPricePerNight());
            hotelListDTO.add(hotelDTO);

        }
        travelPackageDTO.setHotelsDTO(hotelListDTO);
        return travelPackageDTO;
    }

    @Override
    public ResponseDTO addHotelCategoriesOfHotel(String HotelName ,HotelCategoryDTO hotelCategoryDTO) throws TravelManagementSystemException {
        // Fetch the hotel by name
        Hotel hotel = hotelRepository.findByHotelName(HotelName);
        if (hotel == null) {
            throw new TravelManagementSystemException("Hotel not found");
        }

        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelName(HotelName);

        // Create and set HotelCategory
        HotelCategory hotelCategory = new HotelCategory();
        hotelCategory.setCategoryName(hotelCategoryDTO.getCategoryName());
        hotelCategory.setDescription(hotelCategoryDTO.getDescription());
        hotelCategory.setHotel(hotel);  // Set the many-to-one relation

        // Save
        hotelCategoryRepository.save(hotelCategory);

        // Prepare response
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Hotel category added to hotel successfully!");
        return responseDTO;
    }
    @Override
    public List<HotelCategoryDTO> fetchHotelCategoriesOfHotel(String HotelName) throws TravelManagementSystemException
    {
        Hotel hotel = hotelRepository.findByHotelName(HotelName);
        if (hotel == null) {
            throw new TravelManagementSystemException("Hotel not found");
        }
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setHotelLocation(hotel.getHotelLocation());
        List<HotelCategory> hotelCategoryList = hotelCategoryRepository.findByHotel(hotel);
        List<HotelCategoryDTO> hotelCategoryDTOList = new ArrayList<>();
        for(HotelCategory hotelCategory : hotelCategoryList)
        {
            HotelCategoryDTO hotelCategoryDTO = new HotelCategoryDTO();
            hotelCategoryDTO.setCategoryId(hotelCategory.getCategoryId());
            hotelCategoryDTO.setCategoryName(hotelCategory.getCategoryName());
            hotelCategoryDTO.setDescription(hotelCategory.getDescription());
            hotelCategoryDTOList.add(hotelCategoryDTO);

    }
        return hotelCategoryDTOList;

    }

}
