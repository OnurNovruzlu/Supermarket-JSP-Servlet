package dao.imple;

import dao.inter.CategoryDaoInter;
import entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImple implements CategoryDaoInter {

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "Onur", "1234")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while (rs.next()) {
                Category c = getCategory(rs);
                list.add(c);
            }

        } catch (Exception ex) {

        }
        return list;
    }

    @Override
    public Category getCategoryById(int id) {
        Category c = null;
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "Onur", "1234")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from category where category_id=" + id);
            while (rs.next()) {
                return getCategory(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return c;

    }

    @Override
    public Category getCategory(ResultSet rs) throws Exception {
        int category_id = rs.getInt("category_id");
        String category_name = rs.getString("category_name");
        return new Category(category_id, category_name);
    }

    @Override
    public boolean deleteCategory(int id) {
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "Onur", "1234")) {

            Statement st = conn.createStatement();
            return st.execute("delete from category where category_id=" + id);
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public boolean updateProduct(Category c) {
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "Onur", "1234")) {
            PreparedStatement st = conn.prepareStatement("update category set category_name=? where category_id="+c.getCategory_id());
            st.setString(1,c.getCategory_name() );
            return st.execute();
        } catch (SQLException ex) {
            return false;
        }

    }

    @Override
    public boolean insertProduct(Category c) {
        
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "Onur", "1234")) {
            PreparedStatement st = conn.prepareStatement("insert into category(category_id,category_name) values(?,?)");
            st.setInt(1, c.getCategory_id());
            st.setString(2, c.getCategory_name());
            return st.execute();
        } catch (SQLException ex) {
            return false;
        }  
    }
}
