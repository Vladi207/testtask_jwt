package com.grashchenko.testtask_jwt.repository;

import com.grashchenko.testtask_jwt.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
