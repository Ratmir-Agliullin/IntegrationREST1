package IntegrationREST1;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.Response;
//todo воспользуйся автоформатированием кода, в том числе не оставляй неиспользованные импорты
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        try {

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
            System.out.println(answer.toString()); //todo .toString не нужно вызывать у String :)
        } catch (Exception e) {
            // todo: тебе не нужен этот try catch, рантайм ошибки можно кидать и не перехватывать. Ты все равно просто печатаешь стектрейс
            // а стектрейс ты увидишь если исключение провалиться из main
            e.printStackTrace();

        }
    }
}
