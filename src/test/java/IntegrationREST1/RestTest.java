package IntegrationREST1;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
//todo тоже самое с импортами что и в App.class

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

    //todo форматирование кода. Используй автоформатирование идеи. Ctrl + shift + A -> reformat code
 @Test
    public void RestTest(){ //todo название метода не по java naming convention (должен быть lowerCamelCase)
     Client client = Client.create();
     WebResource webResource = client
             .resource("http://localhost:2222/rest/calc/plus/2/3");
     ClientResponse response = webResource.accept("application/json") //todo Используй константы для таких вещей: MediaType.APPLICATION_JSON_TYPE
             .get(ClientResponse.class);

     if (response.getStatus() != 200) {
         throw new RuntimeException("Failed : HTTP error code : "
                 + response.getStatus()); //todo в тестах используй ассерты, чтобы проверять, что тест делает то что тебе нужно: Assert.assertNotEquals("статус должен быть любой, кроме 200", response.getStatus(), 200);

     }

     String answer = response.getEntity(String.class);
    assertEquals("Answer: 6",answer);
     System.out.println(answer.toString()); //todo: такого в production-ready тесте не должно быть. Если очень надо такое в тесте, то надо использовать логирование и логирующие фреймворки. slf4j + logback например. Можешь нагуглить. У нас в проекте используется slf4j + JUL. Но JUL мутная хуйня, не советую.

 }
}
