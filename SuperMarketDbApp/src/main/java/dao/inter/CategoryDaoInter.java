package dao.inter;

import entity.Category;
import entity.Product;
import java.sql.ResultSet;
import java.util.List;

public interface CategoryDaoInter {

    public List<Category> getAllCategories();

    public Category getCategoryById(int id);

    public Category getCategory(ResultSet rs) throws Exception;

    public boolean deleteCategory(int id);

    public boolean updateProduct(Category c);

    public boolean insertProduct(Category c);
}
