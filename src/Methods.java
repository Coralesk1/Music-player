import java.util.Scanner;

public class Methods {
    static Pilha p = new Pilha(20);
    static Scanner scanner = new Scanner(System.in);

    public static void registerMusic(){

        while(true) {
            System.out.println("Enter the name: ");
            String nameMusic = scanner.nextLine();

            System.out.println("Enter the artist: ");
            String artistMusic = scanner.nextLine();

            System.out.println("Enter the duration: ");
            String durationMusic = scanner.nextLine();

            Music registerMusic = new Music(nameMusic, artistMusic, durationMusic);
            p.push(registerMusic);

            while(true){
                System.out.println("\nWant to add more music [Y/N] ?");
                String optionOut = scanner.nextLine().toUpperCase();

                if(optionOut.equals("Y")){
                    System.out.println("Ok...");
                    break;
                }else if(optionOut.equals("N")){
                    System.out.println("Returning to the menu...");
                    return;
                }else {
                    System.out.println("Enter a valid option !");
                }
            }
            scanner.close();
        }

    }
    public static void listAllMusic(){
        p.show();

    }
    public static void searchEspecificMusic(){
        System.out.println("Enter the artist or song title : ");
        String artistOrTitle = scanner.nextLine();

        for()
            //a questão é como comparar o artistOrTitle com um index de um arry

        scanner.close();
    }

}
