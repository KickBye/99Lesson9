package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper {

    static   String  url = "jdbc:mysql://db4free.net:3306/testdatabase9290";
    static   String  userName = "testdatabase9290";
    static   String  password = "123qweASD";

    static Connection con = null;
    static Statement st =null;

    public static Connection init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static ArrayList<HashMap<String, Object>> getSqlResult(final String sql) {

        ResultSet rs = null;
        init();
        ArrayList<HashMap<String, Object>> sqlResult = new ArrayList<>();
        HashMap<String, Object> map = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                map = new HashMap<String, Object>(rsmd.getColumnCount());
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (rs.getObject(i) == null) {
                        map.put(rsmd.getColumnName(i), "");
                    } else {
                        map.put(rsmd.getColumnName(i), rs.getObject(i));
                    }
                }
                sqlResult.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                st.close();
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                con.close();
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sqlResult;
    }
    public static String getValueFirstRow(String sql, String colName) {
        String value = getSqlResult(sql).get(0).get(colName).toString();

        return value;
    }

    public static int countSqlResult(final String sql) {

        int count = 0;
        ResultSet rs = null;
        init();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public static int getInsert(String sql) {

        init();
        int row = 0;

        try {
            st = con.createStatement();
            row = st.executeUpdate(sql);


        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                st.close();
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                con.close();
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }
}

