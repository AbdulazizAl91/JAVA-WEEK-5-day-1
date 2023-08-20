package com.example.schoolmanagemen.Repository;

import com.example.schoolmanagemen.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressByTeacherId(Integer teacher_id);
}
