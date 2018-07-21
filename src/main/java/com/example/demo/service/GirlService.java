package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName GirlService
 * @Description 事务演示
 * @Author ZhaoGQ
 * @Date 2018/7/21 22:16
 * @Version 1.0
 **/
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * @return void
     * @Author ZhaoGQ
     * @Description 事务管理同时插入2条数据
     * @Date 22:18 2018/7/21
     * @Param []
     **/
    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(25);
        girlA.setCupSize("FDD");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(16);
        girlRepository.save(girlB);
    }
}
