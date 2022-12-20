package com.app.educator.repository;

import com.app.educator.dto.UserDto;
import com.app.educator.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    <T>Page<T> findAllByDeletedFalse(Class<T> type, Pageable pageable);

}
