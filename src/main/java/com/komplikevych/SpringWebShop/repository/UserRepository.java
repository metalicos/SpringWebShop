package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);

    void deleteUserByEmail(String email);

    boolean existsUserByEmail(String email);
}
