package com.intern.layoutviews.repo;

import com.intern.layoutviews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<User, Long> {
}
