package com.newcode.cachetest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserDao extends JpaRepository<User, Integer> {}