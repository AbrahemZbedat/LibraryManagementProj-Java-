import java.util.Scanner;

public class Books extends PreBooks implements Compareable  {
   private String title, author;
    private int numberOfPages, bookCode;

    public Books() {
        this.title = "000";
        this.author = "000";
        this.bookCode = 0;
        this.numberOfPages = 0;
    }

    /*********************************************************************************************************/

    public Books(String title, String author, int bookCode, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.bookCode = bookCode;
        this.numberOfPages = numberOfPages;
    }


    /*********************************************************************************************************/






    /*********************************************************************************************************/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return ""  + title +"," + author + "," + bookCode + "," + numberOfPages ;
    }

    /*************************************************************************************************/


    /******************************************************************************************************/
    public int isEqual(String title) {

        if (this.title == title) {
            System.out.println("yes this is the book ");
            return 1;
        }

        return -1;
    }

    /******************************************************************************************************/
    public int compareTo(Books c) {
        try {
            System.out.println("please enter num option what way to perform the comparing? : num 1 is title/num 2 is author/num 3 is NumberOfPages/num 4 is bookCode");
            Scanner inScanner1 = new Scanner(System.in);
            int userOption1 = inScanner1.nextInt();
            switch (userOption1) {
                case 1:
                    return this.title.compareTo(c.title);
                case 2:
                    return this.author.compareTo(c.author);

                case 3:
                    return this.numberOfPages - c.numberOfPages;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return this.title.compareTo(c.title);
    }
        /******************************************************************************************************/
        public void update() {
            try {
                System.out.println("please enter num option what you need to change : num 1 is title/num 2 is author/num 3 is NumberOfPages/num 4 is bookCode");
                Scanner inScanner = new Scanner(System.in);
                int userOption = inScanner.nextInt();
                switch (userOption) {
                    case 1:
                        System.out.println("enter new title");
                        String newTitle = inScanner.next();
                        setTitle(newTitle);
                        break;

                    case 2:
                        System.out.println("enter new author name");
                        String newAuthor = inScanner.next();
                        setAuthor(newAuthor);
                        break;
                    case 3:
                        System.out.println("enter new NumberOfPages");
                        int numberOfPages = inScanner.nextInt();
                        setNumberOfPages(numberOfPages);
                        break;
                    case 4:
                        System.out.println("enter new bookCode");
                        int bookCode = inScanner.nextInt();
                        setBookCode(bookCode);
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        /***********************************************************************************************************/
/**********************************************************************************************************************/
    }



