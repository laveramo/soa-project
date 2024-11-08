package fr.insa.soap.app;
import fr.insa.soap.app.Model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="user")
public class UserService {

	@WebMethod(operationName="create")
	public boolean CreateUser(@WebParam(name="user") User user) {
		if(user.getEmail() != "") {
			return true;
		} else {
			return false;
		}
		
	}
}
