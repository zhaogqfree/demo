package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author ZhaoGQ
 */
@Entity
@Setter
@Getter
public class Girl {
    private String cupSize;
    @Min(value = 18,message = "未满18周岁禁止入内！")
    private Integer age;
    @Id
    @GeneratedValue
    private Integer id;

    public Girl() {
    }
}
