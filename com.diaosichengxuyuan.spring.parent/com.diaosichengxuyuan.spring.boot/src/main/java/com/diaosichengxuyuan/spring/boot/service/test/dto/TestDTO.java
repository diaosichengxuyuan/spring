package com.diaosichengxuyuan.spring.boot.service.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class TestDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name1;

    @NotBlank
    private String name2;

    @NotBlank
    private String name3;

    @NotNull
    private Short age;

    @NotBlank
    private String location;
}