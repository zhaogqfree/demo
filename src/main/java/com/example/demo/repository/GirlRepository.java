package com.example.demo.repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhaoGQ
 * @version 20180721
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    /**
     * @Author ZhaoGQ
     * @Description 通过年龄查找
     * @Date 21:53 2018/7/21
     * @Param [age]
     * @return java.util.List<com.example.demo.domain.Girl>
     **/
     List<Girl> findByAge(Integer age);
}
