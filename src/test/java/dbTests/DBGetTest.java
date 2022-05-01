
////
////import db.DBHelper;
////import org.testng.annotations.Test;
////
////public class DBGetTestDZ7 {
////
////    @Test
////    public void startTest() {
////        String sql = "SELECT * FROM REGISTRATION";
////        DBHelper.getSqlResult(sql).forEach(s -> System.out.println(s));
////        System.out.println(DBHelper.getValueFirstRow(sql, "first"));
////
////        String sql2 = "INSERT REGISTRATION(id, last, first, age) VALUES (20, 'lastname6', 'name6', 31)";
////        DBHelper.getSqlResult(sql).forEach(s -> System.out.println(s));
////        System.out.println("Добавлено строк: " + DBHelper.getInsertSQL(sql2));
////
////        String sql3 = "INSERT REGISTRATION(id, last, first, age) VALUES (21, 'lastname7', 'name7', 19)";
////        DBHelper.getSqlResult(sql).forEach(s -> System.out.println(s));
////        System.out.println("Добавлено строк: " + DBHelper.getInsertSQL(sql2) + DBHelper.getInsertSQL(sql3));
////
////    }
////}
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