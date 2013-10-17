package iw7i.restfulws.hellows;

import javax.ws.rs.client.ClientBuilder;

public class ClientRS {

	public static void main(String[] args) {
		System.out.println(ClientBuilder.newClient()
				.target("http://localhost:8090/helloWorld/sayHello/{name}")
				.resolveTemplate("name", "World!")
				.request("text/plain").get().readEntity(String.class));
	}

}
