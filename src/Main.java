import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan giriş almak için Scanner sınıfını kullanıyoruz.
        Scanner scanner = new Scanner(System.in);
        // Kullanıcıya hoş geldin mesajını yazdırıyor.
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");
        // Kullanıcıdan satır sayısını girmesini istiyor.
        System.out.print("Satır sayısını girin: ");
        int rows = scanner.nextInt();
        // Kullanıcıdan sütun sayısını girmesini istiyoruz.
        System.out.print("Sütun sayısını girin: ");
        int columns = scanner.nextInt();
        // MineSweeper sınıfından bir nesne oluşturarak oyunu başlatıyoruz.
        MineSweeper mineSweeper = new MineSweeper(rows, columns);
        mineSweeper.playGame();  // Oyunu başlatmak için çağırıyoruz.
        // Scanner'ı kapatıyoruz.
        scanner.close();
    }
}