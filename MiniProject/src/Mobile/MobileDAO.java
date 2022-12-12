package Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXParseException;

import ConnectionFactory.ConnectionFactory;

public class MobileDAO {
    public static void createMobileTable() throws SAXParseException{
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "CREATE TABLE Mobile(id int unique, brand VARCHAR(50),model VARCHAR(50),os VARCHAR(50),RAM int,storage int,battery int,processor VARCHAR(50),camera VARCHAR(50),connectivity VARCHAR(50),price int)";
        try(PreparedStatement stmt = con.prepareStatement(SQL)){
            System.out.println("Mobile Table created.");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createMobile(Mobile mob) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into mobile values(?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, mob.getId());
            stmt.setString(2, mob.getBrandName());
            stmt.setString(3, mob.getModelName());
            stmt.setString(4, mob.getOperatingSystem());
            stmt.setInt(5, mob.getRAM());
            stmt.setInt(6, mob.getStorage());
            stmt.setInt(7, mob.getBattery());
            stmt.setString(8, mob.getProcessor());
            stmt.setString(9, mob.getCamera());
            stmt.setString(10, mob.getConnectivity());
            stmt.setInt(11, mob.getPrice());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " mobile row created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMobile(Mobile mob, String update, String updated) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "update mobile set "+ update +" = ? where brand = ? and model = ?";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            if (update == "RAM" || update == "storage" || update == "battery" || update == "price") {
                stmt.setInt(1, Integer.parseInt(updated));
            } else {
                stmt.setString(1, updated);
            }
            stmt.setString(2, mob.getBrandName());
            stmt.setString(3, mob.getModelName());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " mobile rows updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMobile(String id) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "delete from mobile where id = ?";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " mobile rows deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobile> getAllMobile() {
        List<Mobile> Mobiles = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Mobile";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mobile mob = new Mobile(rs.getInt("id"),rs.getString("Brand"), rs.getString("model"), rs.getString("os"),
                        rs.getInt("ram"), rs.getInt("storage"), rs.getInt("battery"), rs.getString("processor"),
                        rs.getString("camera"), rs.getString("connectivity"), rs.getInt("price"));
                Mobiles.add(mob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Mobiles;
    }

    public static List<Mobile> getMobile(String attribute, String value) {
        List<Mobile> mobiles = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from mobile where "+attribute+" = ?";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            if(attribute =="RAM"||attribute=="storage"||attribute=="battery"||attribute=="price"){
                stmt.setInt(1, Integer.valueOf(value));
            }else{
            stmt.setString(1, value);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mobile mob = new Mobile(rs.getInt("id"),rs.getString("Brand"), rs.getString("model"), rs.getString("os"),
                        rs.getInt("ram"), rs.getInt("storage"), rs.getInt("battery"), rs.getString("processor"),
                        rs.getString("camera"), rs.getString("connectivity"), rs.getInt("price"));
                mobiles.add(mob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobiles;
    }

}
