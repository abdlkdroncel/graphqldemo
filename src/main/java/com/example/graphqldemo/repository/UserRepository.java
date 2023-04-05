package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.GraphqlUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GraphqlUser,Long> {
}
