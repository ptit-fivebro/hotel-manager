package com.springframework.hotel.repositories;

import com.springframework.hotel.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select usr from AppUser usr where usr.userName = :userName")
    public AppUser findUserName(@Param("userName") String userName);
}
