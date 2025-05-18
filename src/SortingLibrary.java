import java.util.Comparator;

public class SortingLibrary {

    class SortingByTitle implements Comparator<Books> {
        public int compare(Books z, Books c) {
            return z.getTitle().compareTo(c.getTitle());
        }
    }

    class SortingByNumPages implements Comparator<Books> {
        public int compare(Books z, Books c) {
            return z.getNumberOfPages() - (c.getNumberOfPages());
        }
    }

    class SortingByAuthor implements Comparator<Books> {

        public int compare(Books z, Books c) {
            return z.getAuthor().compareTo(c.getAuthor());
        }
    }

    class SortingByCode implements Comparator<Books> {
        public int compare(Books z, Books c) {
            return z.getBookCode() - (c.getBookCode());
        }
    }
}









