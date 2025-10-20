import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha p = new Pilha(20);

        System.out.println("Welcome to Music Player");
        System.out.println("""
                Choise an Options:
                1 - Register music 
                2 - List songs
                3 - Search music 
                4 - Remove music
        """);
        try{
            System.out.println("Enter the option: ");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Enter the name: ");
                    String nameMusic = scanner.nextLine();

                    System.out.println("Enter the artist: ");
                    String artistMusic = scanner.nextLine();

                    System.out.println("Enter the duration: ");
                    String durationMusic = scanner.nextLine();

                    Music RegisterMusic = new Music(nameMusic, artistMusic, durationMusic);
                    p.push(RegisterMusic);
            }

        }catch (Error e){
            System.out.println(e);
        }


    }
}
