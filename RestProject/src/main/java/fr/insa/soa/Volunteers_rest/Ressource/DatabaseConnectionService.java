package fr.insa.soa.Volunteers_rest.Ressource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("database")
public class DatabaseConnectionService {
	private final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_065";
    private final String username = "projet_gei_065";

    private final String password = "ke1Diemu";

    public static Connection connection;

    //TODO: Handle exception when connections fails
    //TODO: Handle exception when email already exists in database
    //CONSTRUCTOR: Tries to make the database connection with the username and password
	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String DatabaseController() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username,password);
        return "Connected succesufly ";

    }

}
