package org.example.transaction.demos.service;

import org.example.transaction.mybatis.entity.Address;
import org.example.transaction.mybatis.service.AddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zzl
 * @date 2024/1/9 15:10
 */
@Service
public class AddressService {
    @Resource
    private AddressMapper addressMapper;

    public Address find(Integer id){
        return addressMapper.select(id);
    }

    public Integer save(Address address){
        return addressMapper.insert(address);
    }

    public Integer update(Address address){
        return addressMapper.update(address);
    }

    public Integer delete(Address address){
        return addressMapper.delete(address);
    }
}
