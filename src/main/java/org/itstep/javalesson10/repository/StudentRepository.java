package org.itstep.javalesson10.repository;

import org.itstep.javalesson10.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
