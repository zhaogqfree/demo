package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author ZhaoGQ
 * @version 20180721
 */
@Slf4j
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * @return java.util.List<com.example.demo.domain.Girl>
     * @Author ZhaoGQ
     * @Description 查询所有女生列表
     * @Date 21:06 2018/7/21
     * @Param []
     **/
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * @return com.example.demo.domain.Girl
     * @Author ZhaoGQ
     * @Description 添加一个女生
     * @Date 21:15 2018/7/21
     * @Param [cupSize, age]
     **/
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("\n错误信息是: {}", bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return girlRepository.save(girl);
    }

    /**
     * @return java.util.Optional<com.example.demo.domain.Girl>
     * @Author ZhaoGQ
     * @Description 通过id查找一个女生
     * @Date 21:37 2018/7/21
     * @Param [id]
     **/
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    /**
     * @return com.example.demo.domain.Girl
     * @Author ZhaoGQ
     * @Description 更新一个女生信息
     * @Date 21:41 2018/7/21
     * @Param [id, cupSize, age]
     **/
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * @return 
     * @Author ZhaoGQ
     * @Description 删除一个女生
     * @Date 21:45 2018/7/21
     * @Param [id]
     **/
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * @return java.util.List<com.example.demo.domain.Girl>
     * @Author ZhaoGQ
     * @Description 调用在接口中自定义的方法查询
     * @Date 21:57 2018/7/21
     * @Param [age]
     **/
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListsByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * @Author ZhaoGQ
     * @Description //TODO 
     * @Date 23:24 2018/7/21
     * @Param []
     * @return void
     **/
    @GetMapping(value = "/girls/addTwo")
    public void girlTwo() {
        girlService.insertTwo();
    }


}