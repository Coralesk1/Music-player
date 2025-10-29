import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Music> musics = new ArrayList<>();

    public static void registerMusic(){

        while(true) {
            cleanConsole();
            System.out.println("Menu to add music\n");
            System.out.printf("Enter the name: ");
            String nameMusic = scanner.nextLine().trim();

            System.out.printf("Enter the artist: ");
            String artistMusic = scanner.nextLine().trim();

            System.out.printf("Enter the duration: ");
            String durationMusic = scanner.nextLine().trim();

            musics.add(new Music(nameMusic, artistMusic, durationMusic));

            while(true){
                System.out.println("\nWant to add more music [Y/N] ?");
                String optionOut = scanner.nextLine().toUpperCase().trim();

                if(optionOut.equals("Y")){
                    System.out.println("Ok...");
                    break;
                }else if(optionOut.equals("N")){
                    cleanConsole();
                    System.out.println("Returning to the menu...");
                    return;
                }else {
                    cleanConsole();
                    System.out.println("Enter a valid option !");
                }

            }

        }

    }
    public static void listAllMusic(){
        try {
            if(musics.isEmpty()){
                System.out.println("O array esta vazio !");
                return;
            }
            System.out.println("List of all songs.");
            for(Music m : musics ){
                System.out.println(m);
            }
        }catch (Exception e) {
            System.out.println("Arry error !");
        }
        returnMenu();
        cleanConsole();
    }
    public static void searchEspecificMusic(){
        System.out.println("Enter the artist or song title : ");
        String artistOrTitle = scanner.nextLine().trim();
        for(Music m : musics){
            if(artistOrTitle.equals(m.getArtist()) || artistOrTitle.equals(m.getName())){
                System.out.println(m);
            }
        }
        returnMenu();
        cleanConsole();
    }
    public static void deleteMusic(){

        System.out.println("Enter the name of the song you want to delete : ");
        String nameDelete = scanner.nextLine().trim();

        if(nameDelete.isEmpty()){
            System.out.println("Invalid option !");
        }
        for(Music m : musics){
            if(nameDelete.equals(m.getName())){
                musics.remove(m);
            } else{
                System.out.println("Song not found !");
            }
        }
        returnMenu();
        cleanConsole();

    }
    public static void playListMusic(){
        Playlist playlist = new Playlist();
        
        class Playlist {
            
            class Node {
                String dat; // so que aqui vamos ter o nosso objeto musics que tem os dados
                Node next; //aponta para frente 
                Node back; //aponta para traz
    
                public Node (String data){
                    this.data = data;
                }
            }
            class DoublyLinkedList {
                Node head;
                Node tail;
                
                public void add(){
                    Node newNode = new Node(data);
                    if(newNode == null){
                        head = tail = newNode;
                    } else {
                        tail.next = newNode; // o ultimo nó vai apotar para o tail 
                        newNode.back = tail; // agora o nó sabe que o tail é o anterior dele 
                        tail = newNode; //  o novo nó passa a ser o ultimo da lista 
                    }
    
                    
    
                }
                    
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
    public static void returnMenu(){
        System.out.println("Press enter to return to the menu ...");
        scanner.nextLine();
    }


}
