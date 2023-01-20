package config;

import dao.imple.CategoryDaoImple;
import dao.imple.ProductDaoImple;
import dao.imple.UserDaoImpl;
import dao.inter.CategoryDaoInter;
import dao.inter.ProductDaoInter;
import dao.inter.UserDaoInter;

public class Context {
    public static ProductDaoInter instanceProductDao(){
        return new ProductDaoImple();
    }
    public static CategoryDaoInter instanceCategoryDao(){
        return new CategoryDaoImple();
    }
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
