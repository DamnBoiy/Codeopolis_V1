import java.util.function.BinaryOperator;

public class BuecherTestDrive {

    String buchname;
    int buchnummer;
    String genre;

    public void ShowDetails() {
        System.out.println("Buchname: " + buchname + "\nBuchnummer: " + buchnummer + "\nGenre: " + genre);
    }

    public static void main(String[] args) {


        BuecherTestDrive book_1 = new BuecherTestDrive();
        book_1.buchname = "Faust Die Tragödie";
        book_1.buchnummer =10;
        book_1.genre = "Drama";
        book_1.ShowDetails();


    }
}
