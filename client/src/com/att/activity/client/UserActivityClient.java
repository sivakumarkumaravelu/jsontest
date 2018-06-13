package com.att.activity.client;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import com.att.activity.dao.UserActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserActivityClient {

	public static void main(String args[]) {
		Properties prop = new Properties();
		try {		
			prop.load(UserActivityClient.class.getClassLoader().getResourceAsStream("application.properties"));
			String uri=prop.getProperty("URL");
			URL url = new URL(uri);
			ObjectMapper objectMapper = new ObjectMapper();
			UserActivity[] userActivity = objectMapper.readValue(url, UserActivity[].class);
			int numbers[];
			int count=0;
			int total=0;
			
			for (int i = 0; i < userActivity.length; i++) {
				System.out.println(userActivity[i].toString());
				System.out.println("----------------------------------");
				//numbers kept part of JSON, if not process separately
				numbers = userActivity[i].getNumbers();
				for(int j=0;j<numbers.length;j++){
					count += j;
					total +=numbers[j];
				}
			}
			System.out.print("------------------------\n");
			System.out.print("Count : "+count+"\n");
			System.out.println("Total : "+total);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


