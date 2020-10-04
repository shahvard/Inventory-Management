/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ashus
 */
public class ThirdStage extends Stage {
    private ArrayList <Order> orderlist2 = new ArrayList<>();
    private TextArea txtarea2 = new TextArea();
  
    String str1,str2;
    
    Pane pane = new Pane(txtarea2);
    Scene scene = new Scene(addPane(),300,300);
    
    public ThirdStage(String str1){
        this.str1=str1;
        setScene(addScene());
    }
    
    
    private Scene addScene(){
        try{
        orderlist2 = OrderFile.getRecords();
        }catch(Exception e){
            
        }
        for(int i=0;i<orderlist2.size();i++)
        {
            Order obj2 = orderlist2.get(i);
            if ( str1.equals(obj2.getProduct()))
            {
                str2 = "Orders for Product "+ obj2.getProduct()+":\n"
                + "\n"+ obj2.getOrderID()+ " " + obj2.getCustomerID()+" "+
                   obj2.getProduct()+" " + obj2.getShipmethod() + "\n";
            }
        }
        txtarea2.setText(str2);
        return scene;
        
    }
 
     private GridPane addPane(){
        GridPane pane = new GridPane();
        pane.add(txtarea2,1,1);
        return pane;

    }

    
    
    
}
