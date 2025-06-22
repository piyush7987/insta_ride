package com.example.InstaRide.repository;

import com.example.InstaRide.Enum.Gender;
import com.example.InstaRide.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);

   List<Customer> findByGenderAndAge(Gender gender, int age);

 //  @Query("select c from Customer c where c.gender = :gender and c.age > :age") //HQL- Hibernate query lan
 // List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") Gender gender,
 //                                                 @Param("age") int age);

    // Both the query are same only changes are uper one is by HQL and lower one is by SQL

    @Query(value = "select * from customer where gender = :gender and age > :age",
             nativeQuery = true)
    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") String gender,
                                                     @Param("age") int age);


}
