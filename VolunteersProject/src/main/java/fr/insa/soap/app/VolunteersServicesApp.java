package fr.insa.soap.app;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

public class VolunteersServicesApp {
	
	public static String host="localhost";
	public static short port=8090;
	
	public void StartService() {
		String url1 = "http://" + host + ":" + port + "/DBConnection";
        String url2 = "http://" + host + ":" + port + "/SignUp"; 
        
        Endpoint.publish(url1, new DBConnectionService());
        System.out.println("DBConnectionService Started at " + url1);
        
        Endpoint.publish(url2, new SignUpService());
        System.out.println("SignUpService Started at " + url2);;
	}
	
	public static void main(String[] args) throws MalformedURLException {

		new VolunteersServicesApp().StartService();
		System.out.println("Service Started");
	}

}
