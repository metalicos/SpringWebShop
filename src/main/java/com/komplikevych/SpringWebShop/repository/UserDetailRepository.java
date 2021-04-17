package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail getUserDetailByUser(User user);

    void deleteUserDetailByUser(User user);

    boolean existsUserDetailByUser(User user);
}
