package org.example.transaction.demos.service;

import org.example.transaction.mybatis.entity.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;

/**
 * @author zzl
 * @date 2024/1/9 16:02
 */
@Service
public class TransactionServiceB {
    @Resource
    private AddressService addressService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void test(){
        System.out.println("方法B-----" + TransactionSynchronizationManager.getCurrentTransactionName());
        Address address = new Address(1,"郴州777");
        addressService.save(address);
        throw new RuntimeException();
//        System.out.println("------------------方法B执行");
    }
}
