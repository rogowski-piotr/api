package com.piotr.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.ws.http.HTTPException;

public class HttpRequest {

    String url;

    HttpRequest(String url) {
        this.url = url;
    }

    public String request(String timezone) throws IOException, HTTPException {

        String urlAddress = this.url + timezone;

        URL url = new URL(urlAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String r = in.readLine();
            in.close();
            return r;
        } else throw new HTTPException(connection.getResponseCode());
    }

    public String request() throws IOException, HTTPException {

        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String r = in.readLine();
            in.close();
            return r;
        } else throw new HTTPException(connection.getResponseCode());
    }

}
