package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.DepartmentAdmin;

public interface DepartmentAdminRepository extends JpaRepository<DepartmentAdmin,Long> {
//	DepartmentAdmin findByEmailAndDepartmentId(String dept_email, Long departmentId);
	Optional<DepartmentAdmin> findByEmail(String email);
}
