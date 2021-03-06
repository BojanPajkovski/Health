package dao;

import entity.City;
import dbconnection.ConnectionWithPattern;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.09.2018.
 */
public class CityDAOIMPL {

    public void delete(int id) {

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        Statement stmt = null;
        ResultSet rst = null;

        try {

            stmt = conn.createStatement();
            String sqlQuery = "DELETE from city  where city.id = ";
            sqlQuery += id;
            stmt.execute(sqlQuery);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }

    }


    public void insert(City city) throws SQLException {

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        PreparedStatement stmt = null;
        ResultSet rst = null;

        try {

            String sqlQuery = "INSERT INTO city (name , population) VALUES(?,?);";

            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, city.getName());
            stmt.setDouble(2, city.getPopulation());

            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }  finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }


    }

    public void update(City city) throws SQLException {

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        PreparedStatement stmt = null;
        ResultSet rst = null;

        try {

            String sqlQuery = "update city set name =?, population = ? where id= ?";

            stmt = conn.prepareStatement(sqlQuery);

            stmt.setString(1, city.getName());
            stmt.setDouble(2, city.getPopulation());
            stmt.setInt(3, city.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }

    }

    public List<City> getAll() {

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        Statement stmt = null;
        ResultSet rst = null;
        List<City> cities = new ArrayList<City>();
        try {
            stmt = conn.createStatement();
            String sqlQuery = "SELECt * from city";
            rst = stmt.executeQuery(sqlQuery);
            cities = new ArrayList<City>();

            while (rst.next()) {

                int cityId = rst.getInt("id");
                String cityName = rst.getString("name");
                double cityPopulation = rst.getDouble("population");
                City city = new City(cityId, cityName, cityPopulation);
                cities.add(city);


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }
        return cities;
    }

    public City getById (int id){

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        Statement stmt = null;
        ResultSet rst = null;
        City city = new City();
        try {

            stmt = conn.createStatement();

            String sqlQuery = " SELECT * FROM city WHERE id = ";
            sqlQuery+=id;

            rst = stmt.executeQuery(sqlQuery);

            while(rst.next()){

                int cityId = rst.getInt("id");
                String cityName = rst.getString("name");
                double cityPopulation = rst.getDouble("population");

                city = new City(cityId, cityName, cityPopulation);

            }

        }catch(Exception e){

            e.printStackTrace();
        }finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }


        return city;
    }

    public List <City> searchCityByText( String text) {

        Connection conn = ConnectionWithPattern.getConnectionWithPattern();
        Statement stmt = null;
        ResultSet rst = null;
        List<City> cities = new ArrayList<City>();

        try {

            stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM health.city as c where c.name like '";
            sqlQuery += text + "%' ";
            rst = stmt.executeQuery(sqlQuery);

            cities = new ArrayList<City>();


            while (rst.next()) {

                int cityId = rst.getInt("id");
                String cityName = rst.getString("name");
                double cityPopulation = rst.getDouble("population");
                City city = new City(cityId, cityName, cityPopulation);
                cities.add(city);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try { rst.close(); } catch (Exception e)  {   e.printStackTrace(); }
            try { stmt.close(); } catch (Exception e) {  e.printStackTrace(); }
            try { conn.close(); } catch (Exception e) {  e.printStackTrace();}
        }

        return cities;
    }
}