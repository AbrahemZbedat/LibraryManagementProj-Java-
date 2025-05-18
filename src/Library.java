import javax.swing.*;
import java.io.*;
import java.util.*;

public class Library implements BookContract{
    BookDataFile bk= new BookDataFile("Books.txt",",");


 private ArrayList<Books> libraryBooks;
private ArrayList<BookPrice> bookPrice;
    /**************************************************/

    public Library(ArrayList<Books> libraryBooks,ArrayList<BookPrice> bookPrice) throws IOException {
        libraryBooks =  bk.getBooks();
        bookPrice= new ArrayList< BookPrice>();
    }

    /**********************************************************************************************************************/

    public ArrayList<Books> getLibraryBooks() {

        return libraryBooks;
    }

    public void setLibraryBooks(ArrayList<Books> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public ArrayList<BookPrice> getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(ArrayList<BookPrice> bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**********************************************************************************************************************/

    public Library() throws IOException {

            libraryBooks = bk.getBooks();

            bookPrice = new ArrayList<BookPrice>();

            for (int i=0;i<libraryBooks.size();i++){
              int price=  libraryBooks.get(i).getNumberOfPages()*2;
            int  bookCode = libraryBooks.get(i).getBookCode();
                BookPrice n = new BookPrice(bookCode, price);
                bookPrice.add(n);
            }




    }

    /**********************************************************************************************************************/

    public void addBook(Books b) {
        try {
            libraryBooks.add(b);
            bk.writeToFile(libraryBooks,"Books.txt");
            int price = b.getNumberOfPages()*3 ;
            BookPrice n = new BookPrice(b.getBookCode(), price);
            bookPrice.add(n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**********************************************************************************************************************/

    public int searchByBookCode(int bookCode) {
        for (int i = 0; i < libraryBooks.size(); i++) {
            if (libraryBooks.get(i).getBookCode() == bookCode){
                System.out.println("yes found in index:");
                return i;
            }

        }
        System.out.println("book not found");
        return -1;
    }

    /**********************************************************************************************************************/
    public boolean removeBook(Books b) {
        try {
            for (int i = 0; i < libraryBooks.size(); i++) {
                if (libraryBooks.get(i).equals(b)) {
                    libraryBooks.remove(i);


                    bk.writeToFile(libraryBooks, "Books.txt");
                    return true;

                }
            }
            for (int i = 0; i < libraryBooks.size(); i++) {
                if  (bookPrice.get(i).getBookCode()==b.getBookCode()) bookPrice.remove(bookPrice.get(i));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    /**********************************************************************************************************************/
    public void update(int bookCode) throws Exception {
        int z = 0;

try {


        Scanner inScanner3 = new Scanner(System.in);
        for (int i = 0; i < libraryBooks.size(); i++) {

                if (libraryBooks.get(i).getBookCode() == bookCode) {

                    while (z != 6) {
                System.out.println("please enter num option you want to update:" + "\n" + "1. is title" + "\n" + "2. is author" + "\n" +
                        "3. is numOfPgaes" + "\n" +
                        "4. is bookCode" + "\n" + "5. is price" + "\n" + "6. Save and exit");


                z = inScanner3.nextInt();
                switch (z) {
                    case 1:
                        System.out.println("enter new title");
                        String newTitle = inScanner3.next();
                        libraryBooks.get(i).setTitle(newTitle);
                        bk.writeToFile(libraryBooks, "Books.txt");
                        System.out.println("updated successful");
                        break;


                    case 2:
                        System.out.println("enter new author");
                        String newAuthor = inScanner3.next();
                        libraryBooks.get(i).setAuthor(newAuthor);
                        bk.writeToFile(libraryBooks, "Books.txt");
                        System.out.println("updated successful");

                        break;

                    case 3:
                        System.out.println("enter new numOfPgaes");
                        int numOfPages1 = inScanner3.nextInt();
                        libraryBooks.get(i).setNumberOfPages(numOfPages1);
                        bk.writeToFile(libraryBooks, "Books.txt");
                        System.out.println("updated successful");

                        break;

                    case 4:
                        System.out.println("enter new bookCode");
                        int bookCode1 = inScanner3.nextInt();
                        libraryBooks.get(i).setBookCode(bookCode1);
                        bk.writeToFile(libraryBooks, "Books.txt");
                        System.out.println("updated successful");

                        break;

                    case 5:
                        System.out.println("enter new price");
                        int price = inScanner3.nextInt();
                        bookPrice.get(i).setPrice(price);
                        bk.writeToFile(libraryBooks, "Books.txt");
                        System.out.println("updated successful");

                        break;

                    case 6:
                        break;
                }

            }

        }


    }
        System.out.println("The book not found");

} catch (IOException e) {
    throw new RuntimeException(e);
}

    }
/********************************************************************************************************************/
    @Override
    public String toString() {
        return "Library" +
                  libraryBooks ;
    }


     /****************************************************************************************************************/



    public boolean removeByCode(int bookCode) throws IOException {
        boolean flag=true;
        boolean flag1=false;
try {
    flag = Boolean.parseBoolean("The book is removed");
    flag1 = Boolean.parseBoolean("The book not found");

    for (int i = 0; i < bookPrice.size(); i++) {

        if (bookPrice.get(i).getBookCode() == bookCode) {
            bookPrice.remove(i);
        }
    }
    for (int i = 0; i < libraryBooks.size(); i++) {

        if (libraryBooks.get(i).getBookCode() == bookCode) {
            libraryBooks.remove(i);
            bk.writeToFile(libraryBooks, "Books.txt");
            System.out.println("The book is removed");
            return flag;
        }
    }
    System.out.println("The book not found");
    return flag1;

} catch (IOException e) {
    throw new RuntimeException(e);
}


    }








    /********************************************************************************************************************/

    public void removeByIndx(int index) {
        try {
            if (index<= libraryBooks.size()) {
                libraryBooks.remove(index);
                bk.writeToFile(libraryBooks, "Books.txt");
                System.out.println("book is removed");
            }
            else System.out.println("Book not found");
                for (int i = 0; i < bookPrice.size(); i++) {
                    if (libraryBooks.get(index).getBookCode() == bookPrice.get(i).getBookCode()) bookPrice.remove(bookPrice.get(i));

                }

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    /********************************************************************************************************************/
    public void sort() {
        try {
            int result = 0;
            System.out.println("please enter num option what way to perform the sorting?:"+"\n"+"1. is title"+"\n"+"2. is author"+"\n"+"3. is NumberOfPages"+"\n"+"4. is bookCode");
            Scanner inScanner1 = new Scanner(System.in);
            SortingLibrary sort1= new SortingLibrary();
            int userOption1 = inScanner1.nextInt();
            switch (userOption1) {
                case 1:
                    SortingLibrary.SortingByTitle sort2=sort1.new SortingByTitle();
                    Collections.sort(this.getLibraryBooks(),sort2);
                    bk.writeToFile(libraryBooks,"Books.txt");
                    System.out.println("The sort is done");
                    break;
                case 2:
                    SortingLibrary.SortingByAuthor sort3= sort1.new SortingByAuthor();
                    Collections.sort(this.getLibraryBooks(),sort3);
                    bk.writeToFile(libraryBooks,"Books.txt");
                    System.out.println("The sort is done");

                    break;
                case 3:
                    SortingLibrary.SortingByNumPages sort4= sort1.new SortingByNumPages();
                    Collections.sort(this.getLibraryBooks(),sort4);
                    bk.writeToFile(libraryBooks,"Books.txt");
                    System.out.println("The sort is done");

                    break;
                case 4:
                    SortingLibrary.SortingByCode sort5= sort1.new SortingByCode();
                    Collections.sort(this.getLibraryBooks(),sort5);
                    bk.writeToFile(libraryBooks,"Books.txt");
                    System.out.println("The sort is done");

                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    /********************************************************************************************************/
public int size(){
    System.out.println( "The num of books in library is: "+libraryBooks.size());
    return libraryBooks.size();
}
/***************************************************************************************************************/
public boolean isEmpty(){
    if (libraryBooks.isEmpty()==true) return true;
    else return false;
}
/***************************************************************************************************************/
public void clear(){
    try {
        System.out.println("are you sure for delete all elements:-"+"\n"+" 1.yes"+"\n"+" 2.no");
        Scanner inScanner2 = new Scanner(System.in);
        int userOption2 = inScanner2.nextInt();
        switch (userOption2) {
            case 1: libraryBooks.removeAll(libraryBooks);
            bookPrice.removeAll(bookPrice);
                bk.writeToFile(libraryBooks,"Books.txt");
                System.out.println("Done all elements deleted");
            case 2:
                break;
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}
/*******************************************************************************************************************/

public int searchByTitle(String title) {
    for (int i = 0; i < libraryBooks.size(); i++) {
        if (libraryBooks.get(i).getTitle() == title){
            System.out.println("yes found in index:");
            return i;
        }
    }
    System.out.println("book not found");
    return -1;
}
/*******************************************************************************************************************/
public  void displayInfo(){

    JFrame myData;
    myData=new JFrame();
    String[] columns= {"Title","Author","bookCode","numPages","rangeAge","Fee","Genre"};

    String[][] table = new String[libraryBooks.size()][7];
    for (int i = 0; i < libraryBooks.size(); i++)
    {
        table[i][0] = libraryBooks.get(i).getTitle();
        table[i][1] = libraryBooks.get(i).getAuthor();
        table[i][2] = String.valueOf(libraryBooks.get(i).getBookCode());
        table[i][3] = String.valueOf(libraryBooks.get(i).getNumberOfPages());
        if (libraryBooks.get(i) instanceof ChildrenBook==true)  table[i][4] = ((ChildrenBook) libraryBooks.get(i)).getRangeAge();
        if (libraryBooks.get(i) instanceof ElectronicBook==true)  table[i][5] = String.valueOf(((ElectronicBook) libraryBooks.get(i)).getFee());
        if (libraryBooks.get(i) instanceof ElectronicBook==true)  table[i][6] = ((ElectronicBook) libraryBooks.get(i)).getGenre();
    }




    JTable jt=new JTable(table,columns);


    JScrollPane sp=new JScrollPane(jt);
    myData.add(sp);
    myData.setSize(500,500);

    myData.setVisible(true);


}

/**************************************************************************************************************/

public void contains(Books b){
    if (libraryBooks.contains(b)==true) {
        System.out.println(" yes it found");
    }
    else System.out.println("not found");
}
/***********************************************************************************************************/
public void add(int indx,Books b) throws IOException {
    try {
        if (indx<=libraryBooks.size()) {
            libraryBooks.add(indx,b);
            bk.writeToFile(libraryBooks,"Books.txt");
            int price = b.getNumberOfPages()*2 ;
            BookPrice n = new BookPrice(b.getBookCode(), price);
            bookPrice.add(n);

        }
    } catch (Exception e) {
        throw (e);
    }

}
/***************************************************************************************************************/
public int avgPages() throws Exception {
    try {
        int sum=0;
        for (int i = 0; i < libraryBooks.size(); i++){
            sum=sum+libraryBooks.get(i).getNumberOfPages();
        }
        int averge= sum/libraryBooks.size();
        return averge;
    } catch (Exception e) {
        throw new Exception(e);
    }
}
/***************************************************************************************************************/
public int bookPrice(int bookCode){
    try {
        for (int i = 0; i < bookPrice.size(); i++){
            if (bookPrice.get(i).getBookCode()==bookCode){
                System.out.println("The book price per day is : ");return bookPrice.get(i).getPrice();}


        }

    }
    catch (Exception e) {
        System.out.println(new Exception(e));

    }
     System.out.println("The bookprice not found");
    return -1;

}


/***************************************************************************************************************/

    }


