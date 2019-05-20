package dailyHistory;

import java.sql.*;

public class SqlDailyHistory {
   Connection sqlDatabaseConnection;
   PreparedStatement statement;
   ResultSet result;

    public SqlDailyHistory() throws SQLException {
        sqlDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldatabase","root", "root");
    }

    public void delete() throws  SQLException{
        statement = sqlDatabaseConnection.prepareStatement("delete from daily_history");
        statement.execute();
    }


    @Override
    public String toString(){
        try {
            statement = sqlDatabaseConnection.prepareStatement("Select * from daily_history");
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String message = new String();
        while(true)
        {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                message = message + "Client number " +
                result.getInt("client_number") + ": " +
                result.getString("product_name") + " x " +
                result.getInt("product_quantity") + ".\n";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public void addEntry(int clientNumber, String productName, int productQuantity) throws SQLException
    {
        statement = sqlDatabaseConnection.prepareStatement("insert into sqldatabase.daily_history (client_number, product_name, product_quantity) values (?,?,?)");
        statement.setInt(1,clientNumber);
        statement.setString(2, productName);
        statement.setInt(3,productQuantity);
        statement.execute();
    }
}
