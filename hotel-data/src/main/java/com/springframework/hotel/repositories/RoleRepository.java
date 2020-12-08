package com.springframework.hotel.repositories;

import java.util.List;

import com.springframework.hotel.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<AppRole, Long> {

    @Query("select ur.appRole.roleName from UserRole ur where ur.appUser.userId = :userId")
    public List<String> getRoleNames(@Param("userId") Long userId);
}
