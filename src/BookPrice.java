import java.util.Scanner;

public class BookPrice   {
    private int bookCode;

 private    int price;



    /**********************************************************************************************************************/

    public BookPrice(int price) {
        this.price = price;
    }
    /**********************************************************************************************************************/


    /**********************************************************************************************************************/
    /****************************************************************************************************************/

    public BookPrice(int bookCode, int price) {
      this.bookCode=bookCode;
        this.price = price;
    }
    /****************************************************************************************************************/

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookPrice{" +
                "bookCode=" + bookCode +
                ", price=" + price +
                '}';
    }

    /****************************************************************************************************************/
    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }
}
