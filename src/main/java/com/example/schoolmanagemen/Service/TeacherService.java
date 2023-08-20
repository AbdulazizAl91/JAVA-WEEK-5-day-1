package com.example.schoolmanagemen.Service;

import com.example.schoolmanagemen.Api.ApiException;
import com.example.schoolmanagemen.Model.Address;
import com.example.schoolmanagemen.Model.Teacher;
import com.example.schoolmanagemen.Repository.AddressRepository;
import com.example.schoolmanagemen.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public void AddTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if (teacher1==null){
            throw new ApiException("id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);

    }
    public void deleteTeacher(Integer id){
    Teacher teacher= teacherRepository.findTeacherById(id);
        if (teacher==null){
        throw new ApiException("id not found");
        }
        addressRepository.deleteById(id);
        teacherRepository.delete(teacher);
    }
    public Teacher allTeacherDetails(Integer id){
    Address address=addressRepository.findAddressByTeacherId(id);
    if (address==null){
        throw new ApiException("id not found");
    }
    Teacher teacher= address.getTeacher();
    return teacher.getAddress().getTeacher();
    }

}
