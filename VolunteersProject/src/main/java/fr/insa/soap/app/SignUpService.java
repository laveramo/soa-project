package fr.insa.soap.app;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.insa.soap.app.Model.User;

import java.sql.Statement;

@WebService(serviceName="SignUp")
public class SignUpService extends DBConnectionService{
	
	@WebMethod(operationName="create")
	public boolean CreateUser(User user, String password){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("INSERT INTO users (FirstName, LastName, Email, PhoneNumber, Password) VALUES ('%s', '%s', '%s', '%s', '%s');", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), password);
            statement.execute(SQLQuery);
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }
}
