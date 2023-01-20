package dao.inter;

import entity.User;
import java.sql.ResultSet;

public interface UserDaoInter {

    public User findByUsernameAndPassword(String username, String password);

 /*   public User getUser(ResultSet rs) throws Exception;

    public User getUserById(int id);  */
}
