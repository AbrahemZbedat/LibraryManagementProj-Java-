import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BookDataFile {

    private ArrayList<Books> books = null;
    private Path booksPath= null;
    private File booksFile =null;
    private String field_Sep=null;
/*******************************************************************************************************/

    public BookDataFile(String fileName, String sep) throws FileNotFoundException {
        booksPath= Paths.get(fileName);
        this.field_Sep=sep;
        //System.out.println(booksPath);
        booksFile= booksPath.toFile();
        this.books= this.getBooks();
    }
    /*******************************************************************************************************/
public ArrayList<Books> getBooks() throws FileNotFoundException {
 if (books!=null){
     return books;
 }
 books= new ArrayList<Books>();

 if (Files.exists(booksPath)){
     try{

     try

         (BufferedReader in = new BufferedReader(new FileReader(booksFile))){
             String line = " ";

             while (line!=null) {
                 line = in.readLine();
                 if (line == null || line.length() == 0) {
                     continue;
                 }
                 String[] columns = line.split(field_Sep);
                 String title = columns[0];
                 String author = columns[1];
                 String bookCod = columns[2];
                 String numOfPage = (columns[3]);

                 /*********************************/
                // String rangeAge=columns[4];
                 if (columns.length==4) {
                     Books s = new Books(title, author, Integer.parseInt(bookCod), Integer.parseInt(numOfPage));
                     books.add(s);
                 }
                 if (columns.length==5) {
                     String rangeAge=columns[4];
                     ChildrenBook d = new ChildrenBook(title, author, Integer.parseInt(bookCod), Integer.parseInt(numOfPage),rangeAge);
                     books.add(d);
                 }
                 if (columns.length==6) {
                     String fee=columns[4];
                     String genre= columns[5];
                     ElectronicBook w = new ElectronicBook(title, author, Integer.parseInt(bookCod), Integer.parseInt(numOfPage),Integer.parseInt(fee),genre);
                     books.add(w);
                 }
             }
             }
         } catch (IOException e) {
         System.out.println(e);
         return null;
     }
 }
     return books;
 }
 /**************************************************************************************/

 public void writeToFile(ArrayList<Books> bk,String fileName) throws IOException {
FileWriter fw= new FileWriter(fileName);
PrintWriter pw= new PrintWriter(fw);

for (Books bok: bk){
    pw.println(bok.toString());

}
pw.close();

 }
 /*******************************************************************************************/
}

