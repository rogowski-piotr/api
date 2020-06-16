package com.piotr.api;

import com.google.gson.Gson;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApiApplication {

	public static void main (String [] args) {

		HttpRequest r = new HttpRequest("http://worldtimeapi.org/api/timezone/");		// creating object which is a request to worldtimeapi.org
		Gson gson = new Gson();

		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter the argument (time zone):");
		String timezone = myObj.nextLine();													// get argument from the keyboard

		try {
			if (timezone.length() == 0) throw new HTTPException(0);							// if any argument was entered throw exception
			String response = r.request(timezone);											// else create request to the server with given argument (timezone)
			JsonObiect jsOb = gson.fromJson(response, JsonObiect.class);					// deserialization response from the server

			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(jsOb.getDatetime().substring(0,19));	// parse datetime parameter (String) to Date type
			System.out.println(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());						// print the time

		} catch (HTTPException ex) {							// catch any HTTP error code from server
				try {
					String response = r.request();				// request again but this time without any parameter
					List<String> timezones = gson.fromJson(response, new ArrayList<String>().getClass());	// parse response to the list
					System.out.println("\nAvaible arguments (time zones):\n");
					for (String i : timezones)					// print all available arguments (elements of the list)
						System.out.println(i);
				} catch (HTTPException e) {						// catch if any HTTP error code from server during the last request
					System.out.println("Server connection error http code: " + e.getStatusCode());
				} catch (IOException exc) {						// do when an error occurred on the client's side
					System.out.println(exc.getMessage() + " is not available (client error)"); }

		} catch (IOException exc) {					// do when an error occurred on the client's side
			System.out.println(exc.getMessage() + " is not available (client error)");
		} catch (ParseException e) {				// catch if wrong data format during parsing
			System.out.println("Wrong format of date");
		}
	}
}