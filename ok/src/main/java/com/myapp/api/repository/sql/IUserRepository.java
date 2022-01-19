package com.myapp.api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.api.entities.sql.Product;


public interface IUserRepository extends JpaRepository<Product, Integer> {

}
