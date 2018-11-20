package com.example.ribbonconsumer.hystrix;

import com.example.ribbonconsumer.service.UserService;
import com.example.userserver.model.User;
import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserCollapseCommand extends HystrixCollapser<List<User>, User, Long> {
    private UserService userService;
    private Long userId;

    public UserCollapseCommand(UserService userService, Long userId){
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand"))
            .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public Long getRequestArgument() {
        return userId;
    }

    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collection) {
        List<Long> userIds = new ArrayList<>(collection.size());
        userIds.addAll(collection.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }

    @Override
    protected void mapResponseToRequests(List<User> users, Collection<CollapsedRequest<User, Long>> collection) {
        int count = 0;
        for (CollapsedRequest<User, Long> collapsedRequest: collection) {
            User user = users.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
