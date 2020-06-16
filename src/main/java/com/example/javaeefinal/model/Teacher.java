package com.example.javaeefinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Long id;

    private String name;
    private Date create_time;

    private Date update_time;

    private String psw;

}
