package com.example.schoolmanagemen.Model;

import com.example.schoolmanagemen.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
