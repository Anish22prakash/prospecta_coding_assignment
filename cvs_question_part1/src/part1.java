import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class part1 {

    // we can take the scanner class to get the csv data
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("D:\\drirve.csv"));
        sc.useDelimiter(",");
    }
}
