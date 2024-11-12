package fr.insa.soap.app;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="DBConnection")
public class DBConnectionService {
	private static final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_065";
    private static final String username = "projet_gei_065";

    private static final String password = "ke1Diemu";
    
    protected static Connection connection;

	@WebMethod(operationName="connect")
	public boolean Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			System.out.println(connection.getClientInfo());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
