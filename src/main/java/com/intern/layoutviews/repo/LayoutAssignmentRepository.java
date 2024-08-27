package com.intern.layoutviews.repo;

import com.intern.layoutviews.entity.LayoutAssignment;
import com.intern.layoutviews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LayoutAssignmentRepository  extends JpaRepository<LayoutAssignment, Long> {

    Optional<LayoutAssignment> findByUser(User user);
}
