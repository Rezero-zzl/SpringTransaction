package org.example.transaction.demos.service;


import org.example.transaction.mybatis.entity.Address;
import org.example.transaction.mybatis.entity.Person;
import org.example.transaction.mybatis.service.AddressMapper;
import org.example.transaction.mybatis.service.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zzl
 * @date 2024/1/8 17:52
 */
@Service
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    public Person find(Integer id) {
        return personMapper.select(id);
    }

    public Integer save(Person person){
        return personMapper.insert(person);
    }

    public Integer update(Person person){
        return personMapper.update(person);
    }

    public Integer delete(Person person){
        return personMapper.delete(person);
    }
}
