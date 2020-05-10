import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File productList = new File("D:\\Codegym\\Module2-Java\\Week4\\IO-BinaryFile_Serialization\\productManager\\productList.txt");
        Scanner scn = new Scanner(System.in);
        try {
            if (!productList.exists()) {
                throw new FileNotFoundException("File not found");
            }else {
                ProductManager.addProduct(productList,"001","Java",250000,true,"Bài giảng về ngôn ngữ Java");
                ProductManager.addProduct(productList,"002","Js",150000,true,"Bài giảng về ngôn ngữ JavaScipt");
                ProductManager.addProduct(productList,"003","Python",200000,true,"Bài giảng về ngôn ngữ Python");
                ProductManager.addProduct(productList,"004","C++",100000,true,"Bài giảng về ngôn ngữ C++");
                ProductManager.showProductList(productList);
                System.out.print("Enter search name: ");
                String searchValue = scn.nextLine();
                ProductManager.findProductByName(productList,searchValue);

            }

        }catch (FileNotFoundException r){
            System.err.println("File input error: "+r.getMessage());
        }
    }
}
