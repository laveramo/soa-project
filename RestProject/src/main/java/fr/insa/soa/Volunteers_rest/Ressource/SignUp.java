package fr.insa.soa.Volunteers_rest.Ressource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.insa.soa.Volunteers_rest.User;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/signup")
public class SignUp extends DatabaseConnectionService {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean signUp(@BeanParam User user, @FormParam("Password") String password) {
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format(
                "INSERT INTO users (FirstName, LastName, Email, PhoneNumber, Password) VALUES ('%s', '%s', '%s', '%s', '%s');",
                user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), password);
            statement.execute(SQLQuery);
            return true;
            //return Response.status(Response.Status.CREATED).entity("User created successfully").build();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error creating user").build();
        }
    }

}
