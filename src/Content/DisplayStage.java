
package Content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayStage extends Stage {
    
     private ArrayList <Order> orderlist2 = new ArrayList<>();
    private TextArea txtarea = new TextArea();
    String sdata;
    
   Pane pane = new Pane(txtarea);
   Scene scene = new Scene(addPane(),300,300);
    
    
    
    public DisplayStage(ArrayList <Order> orderlist2){
       this.orderlist2 = orderlist2;
       setScene(addScene());
        
    }
    private Scene addScene(){
        for(int i=0;i<orderlist2.size();i++)
        {
           Order obj = orderlist2.get(i);
           sdata +=  obj.getOrderID()+ "," + obj.getCustomerID()+","+
                   obj.getProduct()+"," + obj.getShipmethod()+"\n" ;
           
        } 
        txtarea.setText(sdata);
         return scene;
        
    }
    
    private GridPane addPane(){
        GridPane pane = new GridPane();
        pane.add(txtarea,1,1);
        return pane;

    }
    
    
    
}
