/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author HP USER
 */
public class FourthStage extends Stage{
   
    private Label txtDisplay = new Label();
    private ArrayList<Order> orderList = new ArrayList<>();
    
    public FourthStage (ArrayList<Order> orderList){
        this.orderList = orderList;
        setScene(addScene());
    }

    private Scene addScene() {
        String data = new String();
        data = ("Order id            Customer id             Product             Shipping Method \n");
        for(int i=0;i<orderList.size();i++){
            data += orderList.get(i).getOrderID()+"                   "+orderList.get(i).getCustomerID()+"                      "+orderList.get(i).getProduct()+"                   "
                    +orderList.get(i).getShipmethod()+"\n";
        }
        txtDisplay.setText(data);
        Pane pane = new Pane(txtDisplay);
        Scene scene = new Scene (pane,600,600);
        return scene;
    }
    
}
