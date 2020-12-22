package es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence;
import java.sql.*;
import java.util.Vector;

public class Broker {
    static String dbURL = "jdbc:mysql://172.20.48.70:3306/A02dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "A02";
    static String password = "@ISoft2.2020#";
    protected static Broker mInstancia=null;
    protected static Connection mBD;

    public Broker() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mBD=DriverManager.getConnection(dbURL, username, password);
    }

    public static Broker getBroker() throws Exception {
        if (mInstancia==null) {
            mInstancia=new Broker();
        }
        return mInstancia;
    }

    public static Vector<Object> select(String SQL) throws SQLException, Exception{
        Vector<Object> aux = null;
        Statement stmt = mBD.createStatement();
        ResultSet res=stmt.executeQuery(SQL);
        Vector<Object> vectoradevolver=new Vector<Object>();
        while (res.next()) {
            aux=new Vector<Object>();
            for(int i=1;i<=res.getMetaData().getColumnCount();i++){
                aux.add(res.getObject(i));
                vectoradevolver.add(aux);
            }
        }
        stmt.close();
        return vectoradevolver;
    }
    public static int insert(String sql) throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }

    public static int update(String sql)throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }

    public static int delete(String sql) throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }
}