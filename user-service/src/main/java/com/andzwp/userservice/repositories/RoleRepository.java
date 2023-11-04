package com.andzwp.userservice.repositories;

import com.andzwp.userservice.dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
