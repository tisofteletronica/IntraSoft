package com.softeletronica.intrasoft.repositories.primary;

import com.softeletronica.intrasoft.entities.primary.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}
