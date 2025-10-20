public class Music {
    private String artist;
    private String Name;
    private String duration;

    public Music(String name, String artist, String duration) {
        Name = name;
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
        return Name;
    }

    public void setName(String tile) {
        Name = tile;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
