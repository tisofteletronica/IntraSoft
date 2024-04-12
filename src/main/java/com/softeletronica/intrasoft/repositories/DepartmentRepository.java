package com.softeletronica.intrasoft.repositories;

import com.softeletronica.intrasoft.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
