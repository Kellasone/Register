package restaurant;

import product.Product;

import java.sql.*;
import java.util.ArrayList;

public class SqlRestaurant {
    PreparedStatement statement;
    Connection sqlDatabaseConnection;
    static int clientNumber = 0;
    ResultSet result;

    public SqlRestaurant() throws  SQLException{
        sqlDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
    }

    public void addClient() throws SQLException
    {
        clientNumber++;
        String tableName = "client_" + clientNumber;
        String command  = "CREATE TABLE " + tableName +
                "(" +
                "product_name VARCHAR(45)," +
                " quantity INTEGER" +
                ")";

        Statement statementNotPrepared = sqlDatabaseConnection.createStatement();
        statementNotPrepared.execute(command);
    }

    public void removeClient(int clientNumber) throws SQLException
    {
        String tableName = "client_"+clientNumber;
        String command = "drop table " + tableName;
        Statement statement = sqlDatabaseConnection.createStatement();
        statement.execute(command);

    }
    public void addProductsOnClient(int clientNumber, String productName, int numberOfProducts) throws SQLException {
        String tableName = "client_" + clientNumber;
        String command = "insert into "+tableName + " (product_name, quantity) VALUES (?,?)";
        statement = sqlDatabaseConnection.prepareStatement(command);
        statement.setString(1,productName);
        statement.setInt(2,numberOfProducts);
        statement.execute();
    }
    public void showClientProducts(int clientNumber) throws SQLException
    {
        String tableName ="client_"+clientNumber;
        String command = "Select * from " + tableName;

        statement = sqlDatabaseConnection.prepareStatement(command);

        result = statement.executeQuery();
        String message = "Client " + clientNumber + ":\n";
        while(result.next())
        {
            message = message +result.getString(1) + " x " + result.getInt(2)+".\n";
        }
        System.out.println(message);
    }

    public boolean contains (int clientNumber) throws SQLException
    {
        String tableName = "client_" +clientNumber;
        statement = sqlDatabaseConnection.prepareStatement("Show tables");
        result = statement.executeQuery();

        while(result.next())
        {
           if (result.getString(1).equalsIgnoreCase(tableName))
               return true;
        }
        return false;
    }


    public void listClients() throws SQLException {
        statement = sqlDatabaseConnection.prepareStatement("Show tables");
        result = statement.executeQuery();

        while(result.next())
        {
            String[] tokens = result.getString(1).split("_");
            clientNumber = Integer.parseInt(tokens[1]);
            System.out.print("Client " + clientNumber+ ";");
        }
        System.out.print("\n");

    }

    public void removeClientProducts(int clientNumber, String productToDelete, int numberOfProductsToDelete) throws SQLException{
        /*statement = sqlDatabaseConnection.prepareStatement("delete from ? where product_name = ? and quantity = ?");
        statement.setString(1, "client_"+clientNumber);
        statement.setString(2,productToDelete);
        statement.setInt(3,numberOfProductsToDelete);
        statement.execute();*/
        String command = "delete from client_" + clientNumber + " where product_name='" + productToDelete +"' and quantity='" +numberOfProductsToDelete+"'";
        Statement statement=sqlDatabaseConnection.createStatement();

        statement.execute(command);
    }
/*




    }
*
* */
}
