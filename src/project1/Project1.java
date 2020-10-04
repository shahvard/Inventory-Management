/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import Content.DisplayStage;
import Content.FourthStage;
import Content.Order;
import Content.OrderFile;
import Content.SecondStage;
import Content.ThirdStage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ashus
 */
public class Project1 extends Application {

    private ArrayList<Order> orderlist2 = new ArrayList<>();

    private Label lblorderID = new Label("OrderID");
    private TextField txtorderID = new TextField();
    private Label lblcustomerID = new Label("CustomerID");
    private TextField txtcustomerID = new TextField();
    private Label lblproduct = new Label("Product");
    private TextField txtproduct = new TextField();
    private Label lblship = new Label("Shipping method");
    private TextField txtship = new TextField();

    private Button btnnext = new Button("Next");
    private Button btnprevious = new Button("Previous");
    private Button btnfirst = new Button("First");
    private Button btnlast = new Button("last");
    private Button btnadd = new Button("Add");
    private Button btnupdate = new Button("Update");
    private Button btndelete = new Button("Delete");
    private Button btnViewAllOrders = new Button("View All Orders");
    private Label lblsearch1 = new Label("Customer id :");
    private Button btnsearch1 = new Button("Search");
    private TextField txtsearch1 = new TextField();
    private Label lblsearch2 = new Label("Product: ");
    private Button btnsearch2 = new Button("Search");
    private TextField txtsearch2 = new TextField();
    private TextArea txtarea = new TextArea();

    int sub = 0;

    @Override
    public void start(Stage primaryStage) {

        try {
            orderlist2 = OrderFile.getRecords();
            OrderFile.setRecords(orderlist2);
        } catch (Exception e) {
        }
        Order th = orderlist2.get(0);
        txtorderID.setText(th.getOrderID());
        txtcustomerID.setText(th.getCustomerID());
        txtproduct.setText(th.getProduct());
        txtship.setText(th.getShipmethod());

        btnlast.setOnAction((e) -> {
            sub = orderlist2.size() - 1;
            Order one = orderlist2.get(orderlist2.size() - 1);
            txtorderID.setText(one.getOrderID());
            txtcustomerID.setText(one.getCustomerID());
            txtproduct.setText(one.getProduct());
            txtship.setText(one.getShipmethod());
        });
        btnfirst.setOnAction((e) -> {
            Order one = orderlist2.get(0);
            txtorderID.setText(one.getOrderID());
            txtcustomerID.setText(one.getCustomerID());
            txtproduct.setText(one.getProduct());
            txtship.setText(one.getShipmethod());
        });

        btnnext.setOnAction((e) -> {
            if (sub != orderlist2.size() - 1) {
                sub++;
                Order two = orderlist2.get(sub);
                txtorderID.setText(two.getOrderID());
                txtcustomerID.setText(two.getCustomerID());
                txtproduct.setText(two.getProduct());
                txtship.setText(two.getShipmethod());
            }
        });

        btnprevious.setOnAction((e) -> {
            if (sub != 0) {
                sub--;
                Order two = orderlist2.get(sub);
                txtorderID.setText(two.getOrderID());
                txtcustomerID.setText(two.getCustomerID());
                txtproduct.setText(two.getProduct());
                txtship.setText(two.getShipmethod());
            }
        });

        // UPDATE
        btnupdate.setOnAction((e) -> {

            String a = txtorderID.getText();
            String b = txtcustomerID.getText();
            String c = txtproduct.getText();
            String d = txtship.getText();
            Alert dlgConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = dlgConfirmation.showAndWait();
            String message = new String();

            if (sub == orderlist2.size()) {
                if (result.get() == ButtonType.OK) {
                    String a1 = txtorderID.getText();
                    String b1 = txtcustomerID.getText();
                    String c1 = txtproduct.getText();
                    String d1 = txtship.getText();
                    Order six = new Order(a1);
                    six.setCustomerID(b1);
                    six.setProduct(c1);
                    six.setShipmethod(d1);
                    orderlist2.add(six);
                } else {
                    message = "Add Cancelled";
                    txtorderID.setText(a);
                    txtcustomerID.setText(b);
                    txtproduct.setText(c);
                    txtship.setText(d);
                }

            } else {
                Order three = orderlist2.get(sub);
                if (result.get() == ButtonType.OK) {

                    message = "Updated";
                    String s1 = txtproduct.getText();
                    String s2 = txtship.getText();
                    txtorderID.setText(a);
                    txtcustomerID.setText(b);
                    txtproduct.setText(s1);
                    txtship.setText(s2);
                    three.setProduct(s1);
                    three.setShipmethod(s2);

                } else {
                    message = " Update Cancelled";
                    txtorderID.setText(a);
                    txtcustomerID.setText(b);
                    txtproduct.setText(three.getProduct());
                    txtship.setText(three.getShipmethod());
                }
                Alert dlgMessage = new Alert(Alert.AlertType.INFORMATION);
                dlgMessage.setContentText(message);
                dlgMessage.show();
            }
            try {
                OrderFile.setRecords(orderlist2);
            } catch (IOException ex) {
                System.out.println("Adding not done");
            }

        });

        // DELETE
        btndelete.setOnAction((e) -> {
            Order four = orderlist2.get(sub);
            String a = txtorderID.getText();
            String b = txtcustomerID.getText();
            String c = txtproduct.getText();
            String d = txtship.getText();
            Alert dlgConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = dlgConfirmation.showAndWait();
            String message = new String();
            if (result.get() == ButtonType.OK) {
                orderlist2.remove(sub);
                Order five = orderlist2.get(sub++);
                txtorderID.setText(five.getOrderID());
                txtcustomerID.setText(five.getCustomerID());
                txtproduct.setText(five.getProduct());
                txtship.setText(five.getShipmethod());
                try {
                    OrderFile.setRecords(orderlist2);
                } catch (IOException ex) {
                    System.out.println("Update not done");
                }
            } else {
                message = "Cancelled";
                txtorderID.setText(a);
                txtcustomerID.setText(b);
                txtproduct.setText(c);
                txtship.setText(d);
            }
            Alert dlgMessage = new Alert(Alert.AlertType.INFORMATION);
            dlgMessage.setContentText(message);
            dlgMessage.show();

        });

        btnadd.setOnAction((e) -> {
            sub = orderlist2.size();
            txtorderID.clear();
            txtcustomerID.clear();
            txtproduct.clear();
            txtship.clear();
        });

        btnsearch1.setOnAction((e) -> {
            String a = txtsearch1.getText();
            SecondStage stg1 = new SecondStage(a);
            stg1.show();

            DisplayStage ds = new DisplayStage(orderlist2);
            ds.show();

        });

        btnsearch2.setOnAction((e) -> {
            String b = txtsearch2.getText();
            ThirdStage stg2 = new ThirdStage(b);
            stg2.show();

            DisplayStage ds = new DisplayStage(orderlist2);
            ds.show();
        });
       
        btnViewAllOrders.setOnAction((e) -> {
        FourthStage stg4 = new FourthStage(orderlist2);   
        stg4.show();
        });

        Scene scene = new Scene(addPane(), 500, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private GridPane addPane() {
        GridPane pane = new GridPane();
        pane.add(lblorderID, 0, 0);
        pane.add(txtorderID, 1, 0);
        pane.add(lblcustomerID, 0, 1);
        pane.add(txtcustomerID, 1, 1);
        pane.add(lblproduct, 0, 2);
        pane.add(txtproduct, 1, 2);
        pane.add(lblship, 0, 3);
        pane.add(txtship, 1, 3);
        pane.add(btnfirst, 0, 8);
        pane.add(btnlast, 1, 8);
        pane.add(btnprevious, 0, 9);
        pane.add(btnnext, 1, 9);
        pane.add(btnadd, 3, 1);
        pane.add(btnupdate, 3, 2);
        pane.add(btndelete, 3, 3);
        pane.add(lblsearch1, 0, 12);
        pane.add(btnsearch1, 2, 12);
        pane.add(txtsearch1, 1, 12);
        pane.add(lblsearch2, 0, 14);
        pane.add(btnsearch2, 2, 14);
        pane.add(txtsearch2, 1, 14);
        pane.add(btnViewAllOrders,2,17);

        return pane;

        
        
    }

    public static void main(String[] args) {

        launch(args);

    }

}
