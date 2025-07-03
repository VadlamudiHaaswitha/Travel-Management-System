package com.gl.tms.Respository;

import com.gl.tms.entity.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    public Users findByEmail(String Email);
}
