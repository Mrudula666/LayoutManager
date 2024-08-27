package com.intern.layoutviews.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssignmentRequest {

    private long layoutId;
    private List<Long> userIds;
}
