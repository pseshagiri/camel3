package com.seshagiri.route;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.seshagiri.BookService;

@Component()
public class RestCamelRoute extends RouteBuilder {
	
	private final Environment env;

    public RestCamelRoute(Environment env) {
        this.env = env;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure() throws Exception {
		restConfiguration()		
		.contextPath(env.getProperty("camel.component.servlet.mapping.contextPath",
				"/rest/*"))
		.apiContextPath("/api-doc")
		.apiProperty("api-title", "Spring Camel")
		.apiProperty("api.version", "1.0")
		.apiProperty("cors", "true")
		.apiContextRouteId("doc-api")
		.port(env.getProperty("server.port","9092"))
		.bindingMode(RestBindingMode.json);
		
		rest("/book")		
		.get("/").route()
		.to("{{route.getAllBook}}")
		.endRest();
		
		
		from("{{route.getAllBook}}")
		.bean(BookService.class,"getAllBook");
		
		
		
	}

}
