package com.study;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> { // @Repositoryを書かないサンプルも多い
}
