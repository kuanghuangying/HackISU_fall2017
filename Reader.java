import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Reader{


  public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = Files.readAllLines(Paths.get("p1.txt"));
        for (int i = 0; i < lines.size(); i++){
          System.out.println("line" + i + " " + lines.get(i));
        }
    }
}
