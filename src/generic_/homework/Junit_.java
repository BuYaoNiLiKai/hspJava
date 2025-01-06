package generic_.homework;

//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Junit_ {
    public static void main(String[] args) {


    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 18, "king"));
        dao.save("003", new User(3, 19, "smith"));
        List<User> res = dao.list();
        System.out.println(res);
    }

}
