import java.util.Scanner;

public class ChildrenBook extends Books  {

    private String rangeAge;



    public ChildrenBook(String title, String author, int bookCode, int numberOfPages, String rangeAge) {
        super(title, author, bookCode, numberOfPages);
        this.rangeAge = rangeAge;
    }


    /*************************************************************************************************************/
    public String getRangeAge() {
        return rangeAge;
    }

    public void setRangeAge(String rangeAge) {
        this.rangeAge = rangeAge;
    }

    /****************************************************************************************************************/

    /****************************************************************************************************************/
    @Override
    public String toString() {
         return ""  + super.getTitle() +"," + super.getAuthor() + "," + super.getBookCode() + "," + super.getNumberOfPages() + "," + rangeAge;
    }
    /****************************************************************************************************************/

    public void update() {
        try {
            System.out.println("please enter num option what you need to change : num 1 is title/num 2 is author/num 3 is NumberOfPages/num 4 is bookCode/ num 5 is rangeAge");
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
                case 5:
                    System.out.println("enter new rangeAge");
                    String rangeAge = inScanner.next();
                    setRangeAge(rangeAge);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
