package com.example.schoolmanagemen.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4,max = 20)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email
    @Column(columnDefinition = "varchar(30) not null")
    private String email;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer salary;
    @OneToOne(cascade = CascadeType.DETACH,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
