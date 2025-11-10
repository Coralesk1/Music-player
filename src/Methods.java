import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Music> musics = new ArrayList<>();
    static ArrayList<Playlist> playLists = new ArrayList<>();

    // -------------------- REGISTRA MÚSICA --------------------
    public static void registerMusic() {

        while (true) {
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

                if (!response.equals("y") && !response.equals("n")) {
                    System.out.println("Invalid entry");
                }
            } while (!response.equals("y") && !response.equals("n"));

            if (response.equals("y")) {
                System.out.println("Ok.");
            } else if (response.equals("n")) {
                cleanConsole();
                System.out.println("Returning to the menu...");
                break;
            }
        }
    }

    // -------------------- LISTA TODAS AS MÚSICAS --------------------
    public static boolean listAllMusic() {
        try {
            if (musics.isEmpty()) {
                System.out.println("No music was added !");
                return true;
            }
            System.out.println("List of all songs.");
            for (Music m : musics) {
                System.out.println(m);
            }
        } catch (Exception e) {
            System.out.println("Array error !");
        }
        returnMenu();
        cleanConsole();
        return false;
    }

    // -------------------- BUSCA MÚSICA --------------------
    public static void searchEspecificMusic() {
        System.out.println("Enter the artist or song title : ");
        String artistOrTitle = scanner.nextLine().trim();
        for (Music m : musics) {
            if (artistOrTitle.equalsIgnoreCase(m.getArtist()) ||
                    artistOrTitle.equalsIgnoreCase(m.getName())) {
                System.out.println(m);
            }
        }
        returnMenu();
        cleanConsole();
    }

    // -------------------- DELETA MÚSICA --------------------
    public static void deleteMusic() {
        listAllMusic();
        System.out.println("Enter the name of the song you want to delete : ");
        String nameDelete = scanner.nextLine().trim();

        if (nameDelete.isEmpty()) {
            System.out.println("Invalid option !");
            return;
        }

        boolean found = false;

        for (Music m : musics) {
            if (nameDelete.equalsIgnoreCase(m.getName())) {
                found = true;
                musics.remove(m);
                System.out.println("Song removed successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Song not found!");
        }

        returnMenu();
        cleanConsole();
    }


    // -------------------- CRIAR PLAYLIST --------------------
    public static void creatPlayListMusic() {

        System.out.printf("What will the playlist's name be ? ");
        String namePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(namePlaylist);

        String response;
        do {
            System.out.println("Do you want add songs to this playlist [y/n] ? ");
            response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("y") && !response.equals("n")) {
                System.out.println("Invalid entry. Entry only 'y' or 'n'.");
            }
        } while (!response.equals("y") && !response.equals("n"));

        if (response.equals("y")) {
            System.out.println("Choose a song to add");
            boolean n = Methods.listAllMusic();
            if (n) {
                returnMenu();
                cleanConsole();
                return;
            }

            System.out.println("Add the song by name : ");
            String optionMusicAddPlaylist = scanner.nextLine();
            for (Music music : musics) {
                if (optionMusicAddPlaylist.equalsIgnoreCase(music.getName())) {
                    playlist.addMusic(music);
                    System.out.println("Music added to playlist!");
                }
            }
        } else if (response.equals("n")) {
            returnMenu();
        }

        playLists.add(playlist);
        System.out.println("Playlist created successfully!");

        returnMenu();
        cleanConsole();
    }
    public static void addMusicPlayList(){

    }
    // -------------------- REPRODUZ PLAYLIST --------------------
    public static void PlayPlaylist() {
        System.out.println("Your playlists:");

        if (playLists.isEmpty()) {
            System.out.println("No playlists available!");
            returnMenu();
            return;
        }

        for (Playlist p : playLists) {
            System.out.println("- " + p.getName());
            p.printMusics();
        }

        returnMenu();
    }

    public static class Playlist {
        String namePlaylist;

        // Lista duplamente encadeada para armazenar as músicas
        DoublyLinkedList list = new DoublyLinkedList();

        public Playlist(String namePlaylist) {
            this.namePlaylist = namePlaylist;
        }

        public String getName() {
            return namePlaylist;
        }

        public void addMusic(Music m) {
            list.add(m);
        }

        public void printMusics() {
            list.print();
        }

        // -------------------- NÓ --------------------
        class Node {
            Music music;
            Node next;
            Node back;

            public Node(Music music) {
                this.music = music;
            }
        }

        // -------------------- LISTA DUPLAMENTE ENCADEADA --------------------
        class DoublyLinkedList {
            Node head;
            Node tail;

            public void add(Music music) {
                Node newNode = new Node(music);
                if (head == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.back = tail;
                    tail = newNode;
                }
            }

            public void print() {
                Node currentNode = head;
                if (currentNode == null) {
                    System.out.println("Empty playlist.");
                    return;
                }
                while (currentNode != null) {
                    System.out.println(currentNode.music);
                    currentNode = currentNode.next;
                }
            }
        }
    }

    // -------------------- MÉTODOS AUXILIARES --------------------
    public static void cleanConsole() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(" ");
        }
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static void returnMenu() {
        System.out.println("Press enter to return to the menu ...");
        scanner.nextLine();
    }
}
