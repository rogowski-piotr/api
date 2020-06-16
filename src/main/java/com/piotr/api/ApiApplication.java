package com.piotr.api;

import com.google.gson.Gson;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiApplication {

	public static void main (String [] args) throws IOException {

		HttpRequest r = new HttpRequest("http://worldtimeapi.org/api/timezone/");
		Gson gson = new Gson();

		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter the argument (time zone):");
		String timezone = myObj.nextLine();

		try {
			if (timezone.length() == 0) throw new HTTPException(0);
			String response = r.request(timezone);
			JsonObiect jsOb = gson.fromJson(response, JsonObiect.class);
			System.out.println(jsOb.getDatetime());

		} catch (HTTPException ex) {

				try {
					String response = r.request();
					List<String> timezones = gson.fromJson(response, new ArrayList<String>().getClass());
					System.out.println("\nAvaible time zones:\n");
					for (String i : timezones)
						System.out.println(i);
				} catch (HTTPException e) {
					System.out.println("Server connection error http code: " + e.getStatusCode()); }

		} catch (IOException exc) {
			System.out.println(exc.getMessage() + " is not avaible (client error)"); }
	}
}
