package dbTests;

import db.DBHelper;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class DBGetTest {

    @Test
    public void startTest() {

        String sql = "SELECT * FROM REGISTRATION ORDER BY id DESC";

        int i = Integer.parseInt(DBHelper.getValueFirstRow(sql, "id")) + 1;

        String sqlns = "INSERT INTO REGISTRATION (id, last, first, age) VALUES ('"+i+"', 'newlastname', 'newfirstname', 123)";

        int id1 = DBHelper.countSqlResult(sql);
        DBHelper.getInsert(sqlns);
        int id2 = DBHelper.countSqlResult(sql);
        DBHelper.getSqlResult(sql).forEach(s -> System.out.println(s));

        Assertion as = new Assertion();
        as.assertEquals(Integer.parseInt(DBHelper.getValueFirstRow(sql, "id")), i);
        as.assertTrue(id2 > id1);
        System.out.println("Добавлена строка c id = " + DBHelper.getValueFirstRow(sql, "id"));

    }

}
