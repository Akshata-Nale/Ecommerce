package sample.ecommerce;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Order {

    void placedOrder(String productID) throws SQLException {
        ResultSet res = Main.connection.executeQuery("Select max(OrderID) as OrderID from orders");
        int orderID = 1;
        if(res.next()){
            orderID = res.getInt("orderID")+1;
        }
        Timestamp ts = new Timestamp(Calendar.getInstance().getTime().getTime());
        String query = String.format("Insert Into Orders values(%s,%s,'%s','%s')"
                ,orderID,productID,Main.emailId,ts);
        int response = Main.connection.executeUpdate(query);
        if(response>0) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Order");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Your order is placed");
            dialog.showAndWait();
        }
            //System.out.println("The order is placed");
        else{

        }
            //System.out.println("The order is not placed");
    }
}
