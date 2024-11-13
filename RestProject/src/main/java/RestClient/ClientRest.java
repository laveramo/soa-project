package RestClient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class ClientRest {
	public static void main(String [] args) {
		//Instanciation de client , necessaire pour l'execution des requestes te la consommation des reponses.
		Client client = ClientBuilder.newClient();
		//appel au service Rest, invocation de la methode get correspondant a l'url
		Response response = client.target("http://localhost:8080/RestProject/webapi/comparator/longueurDouble?chaine=yu").request().get();
		//lecture de la reponse recuperee
		System.out.println(response.readEntity(String.class));
	}
}
