package com.att.useractivity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserActivityController {

    @RequestMapping("/useractivity")
    public UserActivity[] getUserActivity() {
        int[] numbers = {1,2,3,4}; 
        UserActivity[] userActivity = new UserActivity[5];
        for (int i = 0; i <= 4; i++) {
        	userActivity[i] = new UserActivity(1,i,"User logged in activity","User logged in with username and password",
            		numbers);
		}        
    	return userActivity;
    }}
