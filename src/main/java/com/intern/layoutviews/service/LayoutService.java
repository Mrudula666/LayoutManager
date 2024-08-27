package com.intern.layoutviews.service;

import com.intern.layoutviews.entity.Layout;
import com.intern.layoutviews.entity.LayoutAssignment;
import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.repo.LayoutAssignmentRepository;
import com.intern.layoutviews.repo.LayoutRepository;
import com.intern.layoutviews.repo.UserGroupRepository;
import com.intern.layoutviews.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LayoutService {
    @Autowired
    private LayoutRepository layoutRepository;
    @Autowired
    private LayoutAssignmentRepository layoutAssignmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;

    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }

    public void assignLayoutToUser(Long userId, Long layoutId) {
        User user = userRepository.findById(userId).orElseThrow();
        Layout layout = layoutRepository.findById(layoutId).orElseThrow();

        Optional<LayoutAssignment> assignedLayout = layoutAssignmentRepository.findByUser(user);
        if (assignedLayout.isEmpty()){
            LayoutAssignment assignment = new LayoutAssignment();
            assignment.setUser(user);
            assignment.setLayout(layout);
            layoutAssignmentRepository.save(assignment);
        }

    }

    public Layout getUserLayout(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return layoutAssignmentRepository.findByUser(user).map(LayoutAssignment::getLayout).orElseThrow();
    }

    public void updateLayout(Long layoutId, String name) {
        Layout layout = layoutRepository.findById(layoutId).orElseThrow();
        layout.setName(name);
        layoutRepository.save(layout);
    }

}
