package dao.imple;

import dao.inter.UserDaoInter;
import entity.Category;
import entity.Product;
import entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements UserDaoInter{

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User u = null;
        try ( Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select username,password from users where username=? and password=?");
            st.setString(1,username);
            st.setString(2, password);
            
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                return new User(rs.getString("username"), rs.getString("password"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/supermarket";
        String username = "Onur";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;

    }
 /*   @Override
    public User getUserById(int id) {
        User u = null;
        try ( Connection conn = connect()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users where id=" + id);
            while (rs.next()) {

                return getUser(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;

    
}

    @Override
    public User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        
        return new User(id, username, password);
    } */
}
