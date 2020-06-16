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
public class Homework {
    private Long id;

    private String title;
    private String content;
    private Date create_time;

    private Date update_time;

    private String total_score;
}
