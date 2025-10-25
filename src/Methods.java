import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Music> musics = new ArrayList<>();

    public static void registerMusic(){

        while(true) {
            System.out.println("Enter the name: ");
            String nameMusic = scanner.nextLine();

            System.out.println("Enter the artist: ");
            String artistMusic = scanner.nextLine();

            System.out.println("Enter the duration: ");
            String durationMusic = scanner.nextLine();

            musics.add(new Music(nameMusic, artistMusic, durationMusic));

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

        }

    }
    public static void listAllMusic(){
        try {
            if(musics.isEmpty()){ //
                System.out.println("O array esta vazio !");
                return;
            }
            for(Music m : musics ){
                System.out.println(m);
            }
        }catch (Exception e) {
            System.out.println("deu err");
        }
    }
    public static void searchEspecificMusic(){
        System.out.println("Enter the artist or song title : ");
        String artistOrTitle = scanner.nextLine();
        for(Music m : musics){
            if(artistOrTitle.equals(m.getArtist()) || artistOrTitle.equals(m.getName())){
                System.out.println(m);
            }
        }
    }
    public static void cleanConsole(){
        for(int i = 1; i <= 50; i++) {
            System.out.println(" ");
        }
    }
    public static void closeScanner(){
        scanner.close();
    }

}
