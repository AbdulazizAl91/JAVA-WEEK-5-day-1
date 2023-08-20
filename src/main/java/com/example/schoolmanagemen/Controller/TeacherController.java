package com.example.schoolmanagemen.Controller;

import com.example.schoolmanagemen.Api.ApiResponse;
import com.example.schoolmanagemen.Model.Teacher;
import com.example.schoolmanagemen.Repository.TeacherRepository;
import com.example.schoolmanagemen.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.AddTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
    }
    @GetMapping("/teacher-details/{id}")
    public ResponseEntity allTeacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.allTeacherDetails(id));
    }

}
