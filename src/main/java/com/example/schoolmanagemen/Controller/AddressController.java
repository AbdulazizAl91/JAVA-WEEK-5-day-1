package com.example.schoolmanagemen.Controller;

import com.example.schoolmanagemen.Api.ApiResponse;
import com.example.schoolmanagemen.DTO.AddressDTO;
import com.example.schoolmanagemen.Model.Address;
import com.example.schoolmanagemen.Model.Teacher;
import com.example.schoolmanagemen.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }
    @PutMapping("/update/{teacher_id}")
    public ResponseEntity updateAddress(@PathVariable Integer teacher_id, @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(teacher_id,addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address updated"));
    }
    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer teacher_id){
        addressService.deleteAddress(teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted"));
    }

}
