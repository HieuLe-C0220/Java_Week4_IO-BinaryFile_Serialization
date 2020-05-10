import java.io.*;
import java.util.LinkedList;

public class ProductManager {
    protected static void addProduct(File list, String id, String name, int price, boolean status, String description) {
        LinkedList<String> line = new LinkedList<>();
        String temp="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(list));
            while ((temp=bufferedReader.readLine())!=null) {
                line.add(temp);
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(list));
            while (!line.isEmpty()) {
                bufferedWriter.write(line.poll()+"\n");
            }
            bufferedWriter.write(id+","+name+","+price+","+status+","+description);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void showProductList(File list) {
        String line = "";
        String[] splited;
        final String TEXT_CUT = ",";
        try(BufferedReader buffRead = new BufferedReader(new FileReader(list))) {

            System.out.println("====Product list====");
            while ((line = buffRead.readLine()) != null) {
                splited=line.split(TEXT_CUT);
                System.out.println("Id: "+splited[0]+", Name: "+splited[1]+
                        ", Price: "+splited[2]+", Status: " +
                        splited[3]+", Description: "+splited[4]);

            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    protected static void findProductByName(File list, String keyword){
        String line ="";
        String[] splited;
        final String TEXT_CUT = ",";
        try (BufferedReader buffRead = new BufferedReader(new FileReader(list))){
            while ((line = buffRead.readLine()) != null){
                splited=line.split(TEXT_CUT);
                if(splited[1].equalsIgnoreCase(keyword)){
                    System.out.println("Product Found:");
                    System.out.println("Id: "+splited[0]+", Name: "+splited[1]+
                            ", Price: "+splited[2]+", Status: " +
                            splited[3]+", Description: "+splited[4]);
                    return;

                }

            }
            System.out.println("Product not found.");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
