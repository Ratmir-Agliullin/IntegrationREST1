package IntegrationREST1;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import static org.junit.Assert.assertEquals;

public class RestTest {


 @Test
    public void RestTest(){
     Client client = Client.create();
     WebResource webResource = client
             .resource("http://localhost:2222/rest/calc/plus/2/3");
     ClientResponse response = webResource.accept("application/json")
             .get(ClientResponse.class);

     if (response.getStatus() != 200) {
         throw new RuntimeException("Failed : HTTP error code : "
                 + response.getStatus());
     }
     String answer = response.getEntity(String.class);
    assertEquals("Answer: 6",answer);
     System.out.println(answer.toString());

 }
}
