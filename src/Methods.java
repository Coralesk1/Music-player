import java.util.Locale;
import java.util.Scanner;

public class Methods {
    public static void registerMusic(){
        Scanner scanner = new Scanner(System.in);
        Pilha p = new Pilha(20);
        boolean outLoop = true;

        while(outLoop) {
            System.out.println("Enter the name: ");
            String nameMusic = scanner.nextLine();

            System.out.println("Enter the artist: ");
            String artistMusic = scanner.nextLine();

            System.out.println("Enter the duration: \n");
            String durationMusic = scanner.nextLine();

            Music registerMusic = new Music(nameMusic, artistMusic, durationMusic);
            p.push(registerMusic);
            p.show();
            while(true){
                System.out.printf("Want to add more music [Y/N] ?");
                String optioOut = scanner.nextLine().toUpperCase();

                if(optioOut.equals("Y")){
                    System.out.println("Ok...");
                }else if(optioOut.equals("N")){
                    System.out.println("Saindo...");
                    outLoop = false;
                    break;
                }else {
                    System.out.println("Enter a valid option !");
                }
            }


        }

    }
}
