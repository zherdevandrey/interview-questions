package com.example.hibernate;

import com.example.hibernate.inheritance.*;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@AllArgsConstructor
public class HibernateApplication implements CommandLineRunner {

    SessionFactory sessionFactory;
  //  DepartmentRepository departmentRepository;
 //   UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {





        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(44411111);
        creditCard.setExpMonth("Jan");
        creditCard.setExpYear("2017");
        creditCard.setOwner("Bill Gates");
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccount(111222333);
        bankAccount.setBankName("Goldman Sachs");
        bankAccount.setSwift("GOLDUS33");
        bankAccount.setOwner("Donald Trump");


        Session session;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction  = session.beginTransaction();
            session.persist(creditCard);
            session.persist(bankAccount);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
        session = sessionFactory.openSession();
        transaction  = session.beginTransaction();
        List billingDetails = session.createQuery("select bd from BillingDetails bd").list();
        for (int i = 0; i < billingDetails.size(); i++) {
            System.out.println(billingDetails.get(i));
        }
        transaction.commit();
        session.close();









//
//        Department sales = new Department("sales");
//        Department it = new Department("it");
//        Department pos = new Department("pos");
//
//        Salary salary1 = new Salary(10);
//        Salary salary2 = new Salary(20);
//        Salary salary3 = new Salary(30);
//
//        User user1 = new User("user1", salary1);
//        User user2 = new User("user2", salary2);
//        User user3 = new User("user3", salary3);
//
//        salary1.setUser(user1);
//        salary2.setUser(user2);
//        salary3.setUser(user3);
//
//        user1.setDepartments(Arrays.asList(sales));
//        user2.setDepartments(Arrays.asList(it));
//        user3.setDepartments(Arrays.asList(pos));
//
//        sales.setUsers(Arrays.asList(user1));
//        it.setUsers(Arrays.asList(user2));
//        pos.setUsers(Arrays.asList(user3));
//
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);

    }
}
