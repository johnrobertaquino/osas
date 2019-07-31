import java.sql.Connection;
import java.util.Date;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.UserDAO;
import org.pup.system.osas.core.domain.User;

public class UserDAOTest {
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtil.createConnection();

		UserDAO userDAO = new UserDAO(connection);

		User user = new User();

		user.setBirthday(new Date());
		user.setContactNumber("09056325698");
		user.setFirstName("Leslie");
		user.setLastName("Balatong");
		user.setMiddleName("Galungong");
		user.setPassword("password");
		user.setPosition("Taga kain");
		user.setUserName("gg");
		
		userDAO.insertUser(user);
		
		System.out.println("userId:" + user.getUserId());
		
		connection.commit();
		
		connection.close();
	}
}
