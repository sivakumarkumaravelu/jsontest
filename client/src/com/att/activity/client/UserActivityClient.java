package com.att.activity.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserActivityClient {

	public static void main(String args[]) {
		Properties prop = new Properties();
		try {		
			prop.load(UserActivityClient.class.getClassLoader().getResourceAsStream("application.properties"));
			String uri=prop.getProperty("URL");
			URL url = new URL(uri);
			ObjectMapper objectMapper = new ObjectMapper();				
			List<Map<String, Object>> jsonList = objectMapper.readValue(url, new TypeReference<List<Map<String, Object>>>(){});

			Map<String, Object> element = null;
			String key;
			int count=0;
			int total=0;

			for (int i = 0; i < jsonList.size(); i++) {
				element = jsonList.get(i);
				for (Map.Entry<String, Object> entry : element.entrySet())
				{	
					key = entry.getKey();
					System.out.print("Key: "+key);
					System.out.println("  ---- Value :"+entry.getValue());
					//numbers kept part of JSON, if not process separately
					if(key.equalsIgnoreCase("numbers")) {
						@SuppressWarnings("unchecked")
						List<Integer> numList = (List<Integer>)entry.getValue();
						for (int j = 0; j < numList.size(); j++) {
							count += j;
							total +=numList.get(j);
						}
					}
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
