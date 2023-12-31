import java.util.*;
import java.util.Scanner;

public class MineSweeper {
    // Oyun alanını temsiz eden diziler
     String[][] minefield; //Mayın alanı
     String[][] userField; // Kullanıcıda görülen mayın alanı
     int rows; // Satır sayısı
     int columns; //Sütun sayısı
     int mines;  // Toplam mayın sayısı
     boolean gameOver; // Oyunun bitip bitmediğini belirten bayrak
     boolean gameWon;  // Oyunun kazanılıp kazanılmadığını belirten bayrak

     // Minesweeper sınıfının kurucu methodu
    public MineSweeper(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.mines = rows * columns / 4; // Eleman sayısının çeyreği kadar mayın
        this.minefield = new String[rows][columns];
        this.userField = new String[rows][columns];
        this.gameOver = false;
        this.gameWon = false;

        // Mayın alanını ve kullanıcı alanını başlatan method
        initializeMinefield();
        placeMines();
        matrisPrinter(minefield);
        initializeUserField();
    }



    // Mayın alanını başlatan method
     void initializeMinefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) minefield[i][j] = " - ";
        }
    }


    public static void matrisPrinter(String[][] array) {

// oluşturduğumuz iki boyutlu arrayleri kullanıcıya göstermek için ekrana bastıran bir method

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");
    }

    // Mayınları yerleştiren method
     void placeMines() {
        Random random = new Random();
        int minesToPlace = mines;
        while (minesToPlace > 0) {
           int row = random.nextInt(rows);
            int col = random.nextInt(columns);
            //int row = (int)Math.random()*rows;
            //int col = (int)Math.random()*columns;
            if (minefield[row][col] != " * ") {
                minefield[row][col] = " * ";
                minesToPlace--;
            }
        }
    }


    // Kullanıcı alanını başlatan method
     void initializeUserField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                userField[i][j] = " - ";
            }
        }
    }


    // Kullanıcı alanını ekrana yazdıran method
    public  void printUserField() {
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(userField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }


    // Oyunu başlatan method
      void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver && !gameWon) {
            printUserField();

            System.out.print("Satır Giriniz: ");
            int row = scanner.nextInt();

            System.out.print("Sütun Giriniz: ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                checkGameStatus();
            } else {
                System.out.println("Geçersiz koordinatlar. Lütfen tekrar girin.");
            }
        }

        scanner.close();
    }


    // Girilen koordinatların geçerli olup olmadığını kontrol eden method
    private boolean isValidMove(int row, int col) {
        return ((row >= 0 && row  < rows) && (col >= 0 &&  col <  columns) && (userField[row][col].equals(" - ")));
    }

    private void makeMove(int row, int col) {
        if (minefield[row][col] == " * ") {
            gameOver = true;
            revealMines();
            printUserField();
            System.out.println("Game Over!!");
        } else {
            revealCell(row, col);
        }


        // Belirli bir hücreyi açan method
    }private void revealCell(int row, int col) {
        int minesAround = countMinesAround(row, col);
        userField[row][col] = (minesAround == 0) ? " 0 " :  (" " + minesAround + " ");

        if (minesAround == 0) {
            //revealNeighbors(row, col);
        }

        // Belirli bir hücre etrafındaki mayın sayısını sayan method
    }private int countMinesAround(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && minefield[i][j] == " * ") {
                    count++;
                }
            }
        }
        return count;
    }


    // Mayınları ortaya çıkaran method
    private void revealMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (minefield[i][j] == " * ") {
                    userField[i][j] = " * ";
                }
            }
        }
    }

    // Oyun durumunu kontrol eden method
    private void checkGameStatus() {
        int unrevealedCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (userField[i][j] == " - " && minefield[i][j] != " * " ) {
                    unrevealedCount++;
                }
            }
        }
        if (unrevealedCount == 0) {
            gameWon = true;
            printUserField();
            System.out.println("Oyunu Kazandınız !");
        }
    }
}

