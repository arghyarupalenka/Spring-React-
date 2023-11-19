package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Ndcapply_Form;
import com.example.demo.Model.Student;
@Repository
public interface NoduesRepository extends JpaRepository<Student, Long>{
	Optional<Student>findByEmail(String email);
}
