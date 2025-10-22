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

            System.out.println("Enter the duration: ");
            String durationMusic = scanner.nextLine();

            Music registerMusic = new Music(nameMusic, artistMusic, durationMusic);
            p.push(registerMusic);
            p.show();
            while(true){
                System.out.println("\nWant to add more music [Y/N] ?");
                String optionOut = scanner.nextLine().toUpperCase();

                if(optionOut.equals("Y")){
                    System.out.println("Ok...");
                }else if(optionOut.equals("N")){
                    System.out.println("Saindo...");
                    // botar o outloop = true aqui? nao false ah tah
                    return;
                }else {
                    System.out.println("Enter a valid option !");
                }
            }


        }
        scanner.close();

    }
}
