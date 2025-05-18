import javax.swing.text.TabableView;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Books x = new Books("bbbb", "aaaa", 4, 34);
        Books c = new Books("aaaa", "hhhh", 7, 34);
        Books d = new Books("cccc", "ppppp", 56, 55);
        ChildrenBook f = new ChildrenBook("ebrahem", "sakhnin", 13, 666, "3-8");

        /*******************************************/
        Library z = new Library();


/*************************************************/
        int userOption1 = 0;
        while (userOption1 != 9) {
            try {
                System.out.println();
                System.out.println("please enter num option :" + "\n" + "1. addBook" + "\n" + "2. removeBook" + "\n" +
                        "3. updateBook" + "\n" + "4. searchBook" + "\n" + "5. sortBooks" + "\n" +
                        "6. displayBooksData" + "\n" + "7. deleteAllBooks" + "\n" + "8. Price book" +  "\n" + "9. quit");
                Scanner inScanner1 = new Scanner(System.in);

                userOption1 = inScanner1.nextInt();
                switch (userOption1) {
                    case 1:
                        z.addBook(addBook());
                        System.out.println("The book added to the library");
                        break;
                    case 2:
                        remove(z);
                        break;
                    case 3:
                        System.out.println("enter bookCode");
                        int bookCode = inScanner1.nextInt();
                        z.update(bookCode);
                        break;
                    case 4:
                        search(z);
                        break;
                    case 5:
                        z.sort();
                        break;
                    case 6:
                        z.displayInfo();
                        break;
                    case 7:
                        z.clear();
                        break;
                    case 8:
                        System.out.println("enter bookCode");
                        int bookCode1 = inScanner1.nextInt();
                        System.out.println(z.bookPrice(bookCode1));
                        break;

                    case 9:
                        break;


                }
            } catch (Exception e) {
                throw e;
            }

        }

    }
    /******************************************************************************************************************/
    /******************************************************************************************************************/
    /******************************************************************************************************************/
// חלק שאילתות
    //quers
    // delete all elements of children book
    public void deleteCildBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ChildrenBook)  z.getLibraryBooks().remove(i);

        }
    }
    // count num children books
    public void countCildBook(Library z) {
        int count=0;
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ChildrenBook)  count=count+1;
            System.out.println(count);
        }
    }
    // count num electronic books
    public void countEleBook(Library z) {
        int count=0;
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ElectronicBook)  count=count+1;
            System.out.println(count);
        }
    }
    // delete all elements of Electronic book

    public void deleteElecBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ElectronicBook)  z.getLibraryBooks().remove(i);

        }
    }
    // avg of price books
    public void avgPrice(Library z) {
        int sum=0;
        for (int i = 0; i < z.getBookPrice().size(); i++) {
          int c= z.getBookPrice().get(i).getPrice();
        sum=sum+c;

        }
        int avg;
        System.out.println( avg= sum/z.getBookPrice().size());
    }
    public void infoElecBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ElectronicBook)  z.getLibraryBooks().toString();
        }
    }
    public void infoCildBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ChildrenBook)  z.getLibraryBooks().toString();
        }
    }
    // if book is electronic the fee is double
    public void feeElecBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ElectronicBook) {  ((ElectronicBook) z.getLibraryBooks().get(i)).setFee(((ElectronicBook) z.getLibraryBooks().get(i)).getFee()*2);
            }
        }
    }
    // if book is electronic the ganre is null
    public void ganreElecBook(Library z) {
        for (int i = 0; i < z.getLibraryBooks().size(); i++) {
            if (z.getLibraryBooks().get(i) instanceof ElectronicBook) {  ((ElectronicBook) z.getLibraryBooks().get(i)).setGenre("null");
            }
        }
    }
    // count how many books the price is big than 100
    public void highPrice(Library z) {
        int count=0;
        for (int i = 0; i < z.getBookPrice().size(); i++) {
            if (z.getBookPrice().get(i).getPrice()>100)  count=count+1;
        }
        System.out.println(count);
    }
   /***********************************************************************************************/
    // end quers








    /******************************************************************************************************************/
    /******************************************************************************************************************/
    /******************************************************************************************************************/
    /******************************************************************************************************************/
    /******************************************************************************************************************/
    // Help methods for the text interface
    public static Books addBook() {
        try {
            Scanner inScanner1 = new Scanner(System.in);
            System.out.println("what book want to add:" + "\n" + "1.normal book" + "\n" + "2.Children book" + "\n" + "3.Electronic Book" );
            int userOption2 = inScanner1.nextInt();

            switch (userOption2) {
                case 1:
                    System.out.println("enter the title");
                    String title = inScanner1.next();
                    System.out.println("enter the author");
                    String author = inScanner1.next();
                    System.out.println("enter bookCode");
                    int bookCode = inScanner1.nextInt();
                    System.out.println("enter numOfPages");
                    int numOfPages = inScanner1.nextInt();
                    Books z = new Books(title, author, bookCode, numOfPages);
                    return z;
                case 2:
                    System.out.println("enter the title");
                    String title1 = inScanner1.next();
                    System.out.println("enter the author");
                    String author1 = inScanner1.next();
                    System.out.println("enter bookCode");
                    int bookCode1 = inScanner1.nextInt();
                    System.out.println("enter numOfPages");
                    int numOfPages1 = inScanner1.nextInt();
                    System.out.println("enter range age");
                    String age = inScanner1.next();
                    ChildrenBook c = new ChildrenBook(title1, author1, bookCode1, numOfPages1,age);
                    return c;
                case 3:
                    System.out.println("enter the title");
                    String title2 = inScanner1.next();
                    System.out.println("enter the author");
                    String author2 = inScanner1.next();
                    System.out.println("enter bookCode");
                    int bookCode2 = inScanner1.nextInt();
                    System.out.println("enter numOfPages");
                    int numOfPages2 = inScanner1.nextInt();
                    System.out.println("enter fee");
                    int fee = inScanner1.nextInt();
                    System.out.println("enter the genre");
                    String genre = inScanner1.next();
                    ElectronicBook e = new ElectronicBook(title2, author2, bookCode2, numOfPages2,fee,genre);
                    return e;

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /******************************************************************************************************************/

    public static void remove(Library z) {
        try {
            System.out.println("what way to want perform the remove?"+"\n"+"1. byIndx"+ "\n"+"2. by bookCode");
            Scanner inScanner1 = new Scanner(System.in);
            int userOption2 = inScanner1.nextInt();

            switch (userOption2) {
                case 1:
                    System.out.println("enter the index");
                    int indx = inScanner1.nextInt();
                    z.removeByIndx(indx);

                    break;
                case 2:
                    System.out.println("enter bookCode");
                    int bookCode = inScanner1.nextInt();
                    z.removeByCode(bookCode);
                    //System.out.println( z.removeByCode(bookCode));
                    break;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    /**********************************************************************************/
public static void search(Library z){
    try {
        System.out.println("what way to want perform the search?"+"\n"+"1. by title"+ "\n"+"2. by bookCode");
        Scanner inScanner1 = new Scanner(System.in);
        int userOption2 = inScanner1.nextInt();

        switch (userOption2) {
            case 1:
                System.out.println("enter the title");
                String title = inScanner1.next();
               int search1= z.searchByTitle(title);
                System.out.println(search1);
                break;
            case 2:
                System.out.println("enter the bookCode");
                int bookCode = inScanner1.nextInt();
              int search=  z.searchByBookCode(bookCode);
                System.out.println(search);
                break;

        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }


}
/*********************************************************************************************/

}
