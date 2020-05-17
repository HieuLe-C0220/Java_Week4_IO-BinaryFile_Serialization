import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CopyFileBinary {
    private static void copyFileBinary(File source,File destiantion) throws IOException {
        final int BUFFER_SIZE = 4096;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(destiantion);
            InputStream inputStr = new BufferedInputStream(fileInputStream,BUFFER_SIZE);
            OutputStream outputStr = new BufferedOutputStream(fileOutputStream,BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            while (inputStr.read(buffer)!=-1) {//Dòng input Stream đọc dòng byte từ file input stream với file path là source sau đó xuất ra mảng byte[] buffer
                outputStr.write(buffer); //Viết ra theo dòng file output stream với file path là destination, nội dung là mảng byte[] buffer
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            fileInputStream.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the source path: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter the destiantion path: ");
        String destPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("File not found.");
            } else if (!destFile.exists()) {
                throw new FileAlreadyExistsException("File already exist.");
            } else {
                copyFileBinary(sourceFile,destFile);
                System.out.println("Copy completed");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File source error: "+e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.out.println("File destination error: "+e.getMessage());
        }
    }
}
