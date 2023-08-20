package com.example.schoolmanagemen.Repository;

import com.example.schoolmanagemen.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);

}
