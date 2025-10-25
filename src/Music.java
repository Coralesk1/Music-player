public class Music {
    private String artist;
    private String name;
    private String duration;

    public Music(String name, String artist, String duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String tile) {
        name = tile;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\nArtist: " + artist +
                "\nDuration: " + duration +
                "\n-----------------------\n";
    }
}
