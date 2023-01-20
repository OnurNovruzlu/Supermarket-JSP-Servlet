package dao.imple;

import config.AbstractDao;
import dao.inter.ProductDaoInter;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImple extends AbstractDao implements ProductDaoInter {

    @Override
    public List<Product> getAllProduct(String name, Integer price) {
        List<Product> list = new ArrayList<>();
        try ( Connection conn = connect()) {

            String sql = "select p.*,c.category_name category "
                    + "from product p left join category c using(category_id) where 1=1 ";
            if (name != null && !name.trim().isEmpty()) {
                sql += " and product_name=?";
            }
            if (price != null) {
                sql += " and product_price=?";
            }
            PreparedStatement st = conn.prepareStatement(sql);
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                st.setString(i,name);
                i++;
            }
            if (price != null) {
                st.setInt(i, price);
            }
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Product p = getProduct(rs);
                list.add(p);
            }
        } catch (Exception ex) {
        }
        return list;
    }

    @Override
    public Product getProductById(int id) {
        Product p = null;
        try ( Connection conn = connect()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select p.*,c.category_name category from product p left join category c using(category_id) where p.product_id=" + id);
            while (rs.next()) {

                return getProduct(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;

    }

    @Override
    public Product getProduct(ResultSet rs) throws Exception {
        int product_id = rs.getInt("product_id");
        String product_name = rs.getString("product_name");
        int product_price = rs.getInt("product_price");
        int category_id = rs.getInt("category_id");
        String category_name = rs.getString("category");
        Category c = new Category(category_id, category_name);

        return new Product(product_id, product_name, product_price, category_id, c);
    }

    @Override
    public boolean removeProduct(int id) {
        try ( Connection conn = connect()) {
            Statement st = conn.createStatement();
            return st.execute("delete from product where product_id=" + id);

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product p) {
        try ( Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("update product set product_name=?,product_price=?,category_id=? where product_id=" + p.getProduct_id());
            st.setString(1, p.getProduct_name());
            st.setInt(2, p.getProduct_price());
            st.setInt(3, p.getCategory_id());
            return st.execute();

        } catch (Exception ex) {

            return false;
        }
    }

    @Override
    public boolean insertProduct(Product p) {
        try ( Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into product(product_id,product_name,product_price,category_id) values (?,?,?,?) ");
            st.setInt(1, p.getProduct_id());
            st.setString(2, p.getProduct_name());
            st.setInt(3, p.getProduct_price());
            st.setInt(4, p.getCategory_id());
            return st.execute();

        } catch (Exception ex) {

            return false;
        }
    }
}
