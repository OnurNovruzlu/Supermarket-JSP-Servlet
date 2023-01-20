package dao.inter;

import entity.Product;
import java.sql.ResultSet;
import java.util.List;

public interface ProductDaoInter {

    public List<Product> getAllProduct(String name,Integer price);

    public Product getProductById(int id);

    public Product getProduct(ResultSet rs) throws Exception;

    public boolean removeProduct(int id);

    public boolean updateProduct(Product p);

    public boolean insertProduct(Product p);

}
