package database;

import product.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDatabase {
    Connection sqlDatabaseConnection;

    public SqlDatabase() throws SQLException {
        sqlDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldatabase", "root", "root");
    }

    public void addProduct(Product productToAdd) throws SQLException {
        PreparedStatement statement;
        String table = productToAdd.getProductType();
        switch (table) {
            case "Alcoholic":
                statement = sqlDatabaseConnection.prepareStatement
                        ("insert into alcoholic " +
                                "(name, price, tva, alcohol_level) " +
                                "VALUES (?, ?, ?, ?)");
                statement.setString(1, productToAdd.getName());
                statement.setDouble(2, productToAdd.getPrice());
                statement.setDouble(3, 0.19);
                statement.setDouble(4, ((Alcoholic) productToAdd).getAlcohol());
                statement.execute();
                break;
            case "NonAlcoholic":
                statement = sqlDatabaseConnection.prepareStatement
                        ("insert into nonalcoholic " +
                                "(name, price, tva, type) " +
                                "VALUES (?, ?, ?, ?)");
                statement.setString(1, productToAdd.getName());
                statement.setDouble(2, productToAdd.getPrice());
                statement.setDouble(3, 0.09);
                statement.setString(4, ((NonAlcoholic) productToAdd).getType());
                statement.execute();
                break;
            case "CleaningProducts":
                statement = sqlDatabaseConnection.prepareStatement
                        ("insert into cleaning_products " +
                                "(name, price, tva, type) " +
                                "VALUES (?, ?, ?, ?)");
                statement.setString(1, productToAdd.getName());
                statement.setDouble(2, productToAdd.getPrice());
                statement.setDouble(3, 0.19);
                statement.setString(4, ((CleaningProducts) productToAdd).getType());
                statement.execute();
                break;
            case "Food":
                statement = sqlDatabaseConnection.prepareStatement
                        ("insert into food " +
                                "(name, price, tva) " +
                                "VALUES (?, ?, ?)");
                statement.setString(1, productToAdd.getName());
                statement.setDouble(2, productToAdd.getPrice());
                statement.setDouble(3, 0.09);
                statement.execute();
                break;
            default:
                System.out.println("Unknown Command");
                break;
        }
    }

    public int removeProduct(String productToRemove) throws SQLException {
        int total = 0;
        PreparedStatement statement;
        statement = sqlDatabaseConnection.prepareStatement("delete from alcoholic where name=?");
        statement.setString(1, productToRemove);
        total += statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("delete from nonalcoholic where name=?");
        statement.setString(1, productToRemove);
        total += statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("delete from food where name=?");
        statement.setString(1, productToRemove);
        total += statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("delete from cleaning_products where name=?");
        statement.setString(1, productToRemove);
        total += statement.executeUpdate();
        return total;
    }

    public boolean contains(String productName) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;
        statement = sqlDatabaseConnection.prepareStatement("Select name from alcoholic where name=?");
        statement.setString(1, productName);
        rs = statement.executeQuery();
        if (rs.next())
            return true;
        statement = sqlDatabaseConnection.prepareStatement("Select name from nonalcoholic where name=?");
        statement.setString(1, productName);
        rs = statement.executeQuery();
        if (rs.next())
            return true;
        statement = sqlDatabaseConnection.prepareStatement("Select name from food where name=?");
        statement.setString(1, productName);
        rs = statement.executeQuery();
        if (rs.next())
            return true;
        statement = sqlDatabaseConnection.prepareStatement("Select name from cleaning_products where name=?");
        statement.setString(1, productName);
        rs = statement.executeQuery();
        if (rs.next())
            return true;

        return false;
    }

    public boolean contains(Product product) throws SQLException {
        String productName = product.getName();
        return contains(productName);
    }

    public Product getProduct(String productName) throws SQLException {
        PreparedStatement statement;
        Product product;
        ResultSet result;

        statement = sqlDatabaseConnection.prepareStatement("Select * from alcoholic where name=?");
        statement.setString(1, productName);
        result = statement.executeQuery();
        while (result.next()) {
            product = new Alcoholic();
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            ((Alcoholic) product).setAlcohol(result.getDouble("alcohol_level"));
            return product;
        }

        statement = sqlDatabaseConnection.prepareStatement("Select * from nonalcoholic where name=?");
        statement.setString(1, productName);
        result = statement.executeQuery();
        while (result.next()) {
            product = new NonAlcoholic();
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            ((NonAlcoholic) product).setType(result.getString("type"));
            return product;
        }

        statement = sqlDatabaseConnection.prepareStatement("Select * from food where name=?");
        statement.setString(1, productName);
        result = statement.executeQuery();
        while (result.next()) {
            product = new Food();
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            return product;
        }

        statement = sqlDatabaseConnection.prepareStatement("Select * from cleaning_products where name=?");
        statement.setString(1, productName);
        result = statement.executeQuery();
        while (result.next()) {
            product = new CleaningProducts();
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            ((CleaningProducts) product).setType(result.getString("type"));
            return product;
        }

        return null;
    }

    public List<Product> getProductList() throws SQLException {
        ArrayList<Product> productList = new ArrayList<>();
        PreparedStatement statement;
        ResultSet resultSet;
        Product newProduct;

        //for alcoholic drinks
        statement = sqlDatabaseConnection.prepareStatement("Select name from alcoholic");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            newProduct = getProduct(resultSet.getString("name"));
            productList.add(newProduct);
        }

        //for nonalcoholic drinks
        statement = sqlDatabaseConnection.prepareStatement("Select name from nonalcoholic");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            newProduct = getProduct(resultSet.getString("name"));
            productList.add(newProduct);
        }

        //for food

        statement = sqlDatabaseConnection.prepareStatement("Select name from food");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            newProduct = getProduct(resultSet.getString("name"));
            productList.add(newProduct);
        }

        //for cleaning products

        statement = sqlDatabaseConnection.prepareStatement("Select name from cleaning_products");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            newProduct = getProduct(resultSet.getString("name"));
            productList.add(newProduct);
        }

        return productList;
    }

    public void changePrice(String productName, double newPrice) throws SQLException {
        PreparedStatement statement;
        statement = sqlDatabaseConnection.prepareStatement("Update alcoholic set price=? where name=?");
        statement.setDouble(1, newPrice);
        statement.setString(2, productName);
        statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("Update nonalcoholic set price=? where name=?");
        statement.setDouble(1, newPrice);
        statement.setString(2, productName);
        statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("Update food set price=? where name=?");
        statement.setDouble(1, newPrice);
        statement.setString(2, productName);
        statement.executeUpdate();

        statement = sqlDatabaseConnection.prepareStatement("Update cleaning_products set price=? where name=?");
        statement.setDouble(1, newPrice);
        statement.setString(2, productName);
        statement.executeUpdate();


    }


}
