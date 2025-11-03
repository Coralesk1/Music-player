import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Music> musics = new ArrayList<>();
    static ArrayList<Playlist> playLists = new ArrayList<>();

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

            String response;
            do {
                System.out.println("\nWant to add more music [y/n] ?");
                response = scanner.nextLine().toLowerCase().trim();

                if(!response.equals("y") && !response.equals("n")) {
                    System.out.println("Invalid entry");
                }
            } while (!response.equals("y") && !response.equals("n"));
            if (response.equals("y")){
                System.out.println("Ok.");
            } else if (response.equals("n")){
                cleanConsole();
                System.out.println("Returning to the menu...");
                break;
            }
        }

    }
    public static boolean listAllMusic(){
        try {
            if(musics.isEmpty()){
                System.out.println("No music was added !");
                returnMenu();
                return true;
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
        return false;
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
    public static class Playlist {
        String namePlaylist;
        DoublyLinkedList list;

        public Playlist(String namePLaylist){
            this.namePlaylist = namePLaylist;
        }
        @Override
        public String toString(){
            return "-" + namePlaylist;
        }
        public void addMusic(Music music) {
            list.add(music);
        }
        class Node {
            Music musics; // so que aqui vamos ter o nosso objeto musics que tem os dados
            Node next; //aponta para frente
            Node back; //aponta para traz

            public Node (Music musics){
                this.musics = musics;
            }

        }
        class DoublyLinkedList {
            Node head;
            Node tail;

            public void add(Music musics){
                Node newNode = new Node(musics);
                if(head == null && tail == null){
                    head = tail = newNode;
                } else {
                    tail.next = newNode; // o ultimo nó vai apotar para o tail
                    newNode.back = tail; // agora o nó sabe que o tail é o anterior dele
                    tail = newNode; //  o novo nó passa a ser o ultimo da lista
                }
            }
            public void print(){
                Node currentNode = head; // começa do head
                while(currentNode != null){
                    System.out.println(currentNode.musics); //printa as musicas
                    currentNode = currentNode.next; //vai para o proximo nó
                    if (currentNode == null){
                        break;
                    }
                }
            }
        }
    }
    public static void playListMusic(){

        System.out.printf("What will the playlist's name be ? ");
        String namePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(namePlaylist);
        Playlist.DoublyLinkedList list = playlist.new DoublyLinkedList();

        String response;
        do {
            System.out.println("Do you want add songs to this playlist [y/n] ? ");
            response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("y") && !response.equals("n")) {
                System.out.println("Invalid entry. Entry only 'y' or 'n'.");
            }
        } while (!response.equals("y") && !response.equals("n"));

        if (response.equals("y")) {
            System.out.println("Choise a song to add");
            boolean n = Methods.listAllMusic();
            if(!n){
                returnMenu();
                cleanConsole();
                return;
            }

            System.out.println("Add the song by name : ");
            String optionMusicAddPlaylist = scanner.nextLine();
            for(Music music : musics){
                if (optionMusicAddPlaylist.equals(music.getName())){
                    playlist.addMusic(music);
                    list.add(music);
                }
            }
        } else if(response.equals("n")){
            returnMenu();
        }

        playLists.add(playlist);
        System.out.println("Playlist created successfully!");

    }
    public static void PlayPlaylist(){
        System.out.println("Your playlists");
        for (Playlist p : playLists){
            System.out.println(p);
        }
        System.out.println("Which playlist do you want to play ? ");
        String playListChoicePlay = scanner.nextLine();


        returnMenu();

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
