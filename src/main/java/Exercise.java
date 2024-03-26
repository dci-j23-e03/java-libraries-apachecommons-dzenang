import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class Exercise {
  public static void main(String[] args) throws IOException, InterruptedException {

    // Import library
    if (checksum()) {
      System.out.println("Successfully imported the Apache Commons IO library");
    } else {
      System.out.println("Wrong version of the library");
    }

    // Working with Streams
    readWebPage("https://digitalcareerinstitute.org/");

    // Working with files
    readFile("LoremIpsum.txt");
    copyFile("LoremIpsum.txt");

    // Find files with extension .java in other project
    findJavaFiles("./");
  }


  private static boolean checksum() throws IOException {
    // TODO: Add your code here

    return checksum == 2449403980L;
  }

  private static void readWebPage(String url) throws IOException {
    System.out.println("\n\nReading " + url);
    InputStream in = new URL(url).openStream();

    // TODO: Add your code here
  }

  private static void readFile(String fileName) throws IOException {
    System.out.println("\n\nReading LoremIpsum.txt:");
    // TODO: Add your code here
  }

  private static void copyFile(String fileName) throws IOException, InterruptedException {
    System.out.println("\n\nCreating a copy of LoremIpsum.txt in " + FileUtils.getTempDirectory());
    // TODO: Add your code here

    Thread.sleep(150);

    // TODO: Add your code here
  }

  private static void findJavaFiles(String relativePath) {
    System.out.println("\n\nListing all java files in directory " + relativePath);
  }
}
