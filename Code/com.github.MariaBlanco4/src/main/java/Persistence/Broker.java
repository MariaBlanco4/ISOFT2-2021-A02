package Persistence;
import java.sql.*;
import java.util.Vector;

public class Broker {
    static String dbURL = "jdbc:mysql://localhost:3306/PruebaBBDD"; //Esta string es el path de nuestra bbdd
    static String username = "root"; //El usuario que por defecto es root
    static String password = "3459443"; //Contraseña que le puse para poder acceder
    protected static Broker mInstancia=null;
    protected static Connection mBD;

    public Broker() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mBD=DriverManager.getConnection(dbURL, username, password);
    }

    public static Broker getAgente() throws Exception {
        if (mInstancia==null) {
            mInstancia=new Broker();
        }
        return mInstancia;
    }

    public Vector<Object> select(String SQL) throws SQLException, Exception{
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

    public int update(String sql)throws Exception{
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