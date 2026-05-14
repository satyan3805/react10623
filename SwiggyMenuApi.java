package com.sat.tmf.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SwiggyMenuApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SwiggyMenuApi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url =
                "https://www.swiggy.com/dapi/menu/pl" +
                "?page-type=REGULAR_MENU" +
                "&complete-menu=true" +
                "&lat=17.6852956" +
                "&lng=83.20374009999999" +
                "&restaurantId=858813" +
                "&catalog_qa=undefined" +
                "&submitAction=ENTER";

        HttpClient client = HttpClient.newBuilder()
                .build();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("accept", "application/json")
                .header("accept-language", "en-US,en;q=0.9")
                .header("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/147.0.0.0 Safari/537.36")
                .header("referer", "https://www.swiggy.com/")
                .header("cookie",
                        "__SW=edIe2VGdaWe-qhqnwj7-wniKgjJgWrHQ;" +
                        " aws-waf-token=df5c8cb1-712f-4288-9306-18d5ba4a1a52:HgoAbDwq3PsvAAAA:UZuOzWofy/wvX4pFUT8PDy1q1NbhVQmtT4hssOGjlBLl4gB+3djsElUHNcdzEOkyWVu/z+mrQ/uieD9kCGkqRlES4EByABKFrB8235taVQcBHm+Em0987aL3smEaEAN4Ay4r9IzgAI/dibRbhWNbt835KV8HLLjRYLTS0uj2eAPoCAHl/h55oL/RAXcJZ3fBjgT54jqdBYoPAF6ySiRHkpz8FNFj1zZICR2YD7ftSZrRyaY2LUfNC1yaokTBrCMWKAb7pCQ=;" +
                        " _device_id=26961404-cd6a-ba28-7de3-bb8b88e8969c")
                .GET()
                .build();

        try {

            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

            response.setHeader("Access-Control-Allow-Origin", "http://localhost:1234");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.print(res.body());
            out.flush();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
