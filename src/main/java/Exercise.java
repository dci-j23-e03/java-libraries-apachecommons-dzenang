import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Exercise {
  private static final String COMMONS_IO_PATH = "lib/commons-io-2.11.0.jar";
  private static final String LOREM_IPSUM_PATH = "src/main/resources/LoremIpsum.txt";
  private static final File TEMP_DIR = FileUtils.getTempDirectory();

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
    File jar = new File(COMMONS_IO_PATH);

    long checksum = FileUtils.checksumCRC32(jar);
    return checksum == 2449403980L;
  }

  private static void readWebPage(String url) throws IOException {
    System.out.println("\n\nReading " + url);
    try(InputStream in = new URL(url).openStream()) {
      String webPageContent = IOUtils.toString(in, "UTF-8");
//      System.out.println(webPageContent);
    }
  }

  private static void readFile(String fileName) throws IOException {
    System.out.println("\n\nReading LoremIpsum.txt:");

    File loremIpsum = new File(LOREM_IPSUM_PATH);
    System.out.println(FileUtils.readFileToString(loremIpsum, "UTF-8"));
  }

  private static void copyFile(String fileName) throws IOException, InterruptedException {
    System.out.println("\n\nCreating a copy of LoremIpsum.txt in " + TEMP_DIR);

    File loremIpsum = new File(LOREM_IPSUM_PATH);

    FileUtils.copyFileToDirectory(loremIpsum, TEMP_DIR);

    Thread.sleep(150);

    File copy = new File(TEMP_DIR, loremIpsum.getName());
    FileUtils.delete(copy);
  }

  private static void findJavaFiles(String relativePath) {
    System.out.println("\n\nListing all java files in directory " + relativePath);

    File dir = new File(relativePath);
    String[] extensions = {"java"};
    Collection<File> files = FileUtils.listFiles(dir, extensions, true);
    for (File file : files) {
      System.out.println(file);
    }
  }
}
