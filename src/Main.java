import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to Music Player");
            System.out.println("""
                Choise an Options:
                1 - Register music 
                2 - List songs
                3 - Search music 
                4 - Remove music
                5 - Create playlist
                6 - Add music to playlist
                0 - Exit program
               """);

            System.out.printf("Enter the option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    Methods.registerMusic();
                    continue;
                case 2:
                    Methods.cleanConsole();
                    Methods.listAllMusic();
                    continue;
                case 3:
                    Methods.cleanConsole();
                    Methods.searchEspecificMusic();
                    continue;
                case 4:
                    Methods.cleanConsole();
                    Methods.deleteMusic();
                    continue;
                case 5:
                    Methods.cleanConsole();
                    Methods.creatPlayListMusic();
                    continue;
                case 6:
                    Methods.cleanConsole();
                    Methods.addMusicPlayList();
                    continue;
                case 0:
                    Methods.closeScanner();
                    System.out.println("Stopping the program ...");
                    return;
                default:
                    Methods.cleanConsole();
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
