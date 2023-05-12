package com.study;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { // @Repositoryを書かないサンプルも多い
}/////