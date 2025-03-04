package dao.test;

import dao.dao.GoodsDAO;
import dao.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    @Test
    void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();
        // 多行查询
        List<Goods> goodsList = goodsDAO.queryMulti("select *from goods", Goods.class);
        for (Goods good : goodsList) {
            System.out.println(good);
        }

        // 单行
        Goods goods = goodsDAO.querySingle("select * from goods where id =?", Goods.class, 1);
        System.out.println(goods);

        // 单行单列
        Object obj = goodsDAO.queryScalar("select goods_name from goods where id =?", 3);
        System.out.println(obj);

        // update操作
        int affect = goodsDAO.update("insert into goods values(null,?,?)", "小米", 4752.36);
        System.out.println(affect);

    }
}
