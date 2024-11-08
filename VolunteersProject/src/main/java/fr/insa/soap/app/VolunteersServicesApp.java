package fr.insa.soap.app;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

public class VolunteersServicesApp {
	
	public static String host="localhost";
	public static short port=8090;
	
	public void StartService() {
		String url = "http://"+host+":"+port+"/";
		Endpoint.publish(url, new UserService());
	}
	
	public static void main(String[] args) throws MalformedURLException {

		new VolunteersServicesApp().StartService();
		System.out.println("Service Started");
	}

}
