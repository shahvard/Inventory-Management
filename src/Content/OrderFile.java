
package Content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrderFile{
    
      public static ArrayList <Order> getRecords() throws IOException {
       
        FileReader fr = new FileReader("Order.dat");
        BufferedReader br = new BufferedReader(fr);
         ArrayList <Order> orderList = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
                
            StringTokenizer st = new StringTokenizer(line, ",");
          while(st.hasMoreElements()){
            String orderID = st.nextToken();
            String customerID =st.nextToken();
            String product = st.nextToken();
            String shipmethod = st.nextToken();
            
            Order one = new Order(orderID);
            one.setCustomerID(customerID);
            one.setProduct(product);
            one.setShipmethod(shipmethod);
            orderList.add(one);}
            line = br.readLine();
            
           
        }
        br.close();
        fr.close();
        
        return orderList;

    }
      
     public static void setRecords(ArrayList <Order> orderList)throws IOException{
        FileWriter fw = new FileWriter("Order.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(int sub=0;sub<orderList.size();sub++){
            
            Order one = orderList.get(sub);
            String sdata = one.getOrderID()+ "," + one.getCustomerID() +"," +
                    one.getProduct()+"," + one.getShipmethod();
            bw.write(sdata);
            bw.newLine();         
        }
        bw.close();
        fw.close();
    }  
   

      
}
