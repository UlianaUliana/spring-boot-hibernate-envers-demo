package com.ns.springboothibernateenvers.repository;

import com.ns.springboothibernateenvers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
