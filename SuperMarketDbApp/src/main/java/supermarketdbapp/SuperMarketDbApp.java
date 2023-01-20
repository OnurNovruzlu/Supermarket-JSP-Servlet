package supermarketdbapp;

import config.Context;
import dao.inter.UserDaoInter;

public class SuperMarketDbApp {

    public static void main(String[] args) {
        UserDaoInter udao=Context.instanceUserDao();
        System.out.println(udao.findByUsernameAndPassword("onur", "1234"));
    }
}
