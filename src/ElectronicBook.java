import java.util.Scanner;

public class ElectronicBook extends Books {
  private  int fee;
    private String genre;

    /*********************************************************************************************************/



    public ElectronicBook(String title, String author, int bookCode, int numberOfPages, int fee,String genre) {
        super(title, author, bookCode, numberOfPages);
        this.fee = fee;
        this.genre=genre;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    /*********************************************************************************************************/
    @Override
    public String toString() {
        return ""  + super.getTitle() +"," + super.getAuthor() + "," + super.getBookCode() + "," + super.getNumberOfPages() + "," + fee+","+genre ;
    }
    /*********************************************************************************************************/


    public void update() {
        try {
            System.out.println("please enter num option what you need to change : num 1 is title/num 2 is author/num 3 is NumberOfPages/num 4 is bookCode/num 5 is fee/num 6 is genre");
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
                    System.out.println("enter new fee");
                    int fee = inScanner.nextInt();
                    setFee(fee);
                    break;
                case 6:
                    System.out.println("enter new genre");
                    String genre = inScanner.next();
                    setGenre(genre);
                    break;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
