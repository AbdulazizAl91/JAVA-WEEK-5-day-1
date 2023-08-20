package com.example.schoolmanagemen.Service;

import com.example.schoolmanagemen.Api.ApiException;
import com.example.schoolmanagemen.DTO.AddressDTO;
import com.example.schoolmanagemen.Model.Address;
import com.example.schoolmanagemen.Model.Teacher;
import com.example.schoolmanagemen.Repository.AddressRepository;
import com.example.schoolmanagemen.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException("teacher not found");
        }
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(Integer teacher_id,AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);

        if(teacher == null){
            throw new ApiException("teacher not found");
        }
        Address address = teacher.getAddress();

        address.setArea(addressDTO.getArea());
        address.setStreet(address.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);

    }
    public void deleteAddress(Integer teacher_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Address address = teacher.getAddress();
        addressRepository.delete(address);

    }



}
