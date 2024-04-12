package com.softeletronica.intrasoft.repositories;

import com.softeletronica.intrasoft.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}
