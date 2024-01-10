package org.example.transaction.demos.service;

import org.example.transaction.mybatis.entity.Address;
import org.example.transaction.mybatis.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;

/**
 * @author zzl
 * @date 2024/1/9 15:21
 */
@Service
public class TransactionServiceA {
    @Resource
    private PersonService personService;
    @Resource
    private AddressService addressService;
    @Resource
    private TransactionServiceB transactionServiceB;

    public void test() {
        Person person = new Person("李四", true);
        personService.save(person);
        Address address = new Address(person.getId(), "郴州");
        addressService.save(address);

        person.setName("李五");
        address.setAddress("cs");
        personService.update(person);
        addressService.update(address);

        Person person1 = personService.find(person.getId());
        Address address1 = addressService.find(address.getId());

        personService.delete(person);
        addressService.delete(address);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test1() {
        Person person = new Person("77", true);
        personService.save(person);
        System.out.println("方法A-----" + TransactionSynchronizationManager.getCurrentTransactionName());
/*        try {
            transactionServiceB.test();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }*/
//        System.out.println("------------------方法B执行");

        new Thread(() -> {
            System.out.println("thread----" + TransactionSynchronizationManager.getCurrentTransactionName());
            try {
                transactionServiceB.test();
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
        }).start();
//        throw new RuntimeException();
    }


}
