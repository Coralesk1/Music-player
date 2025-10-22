import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Music Player");
        System.out.println("""
                Choise an Options:
                1 - Register music 
                2 - List songs
                3 - Search music 
                4 - Remove music
        """);

        System.out.printf("Enter the option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                Methods.registerMusic();
                break;
            default:
                break;
        }

    }
}
