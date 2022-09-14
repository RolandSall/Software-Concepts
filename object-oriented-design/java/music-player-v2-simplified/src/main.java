import java.util.*;

enum Genre {
    ROCK,
    JAZZ,
    POP
}

class Singer {
    private int id;
    private String firstName;
    private List<Song> songs;

    public Singer(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
        songs = new ArrayList<>();
    }

}

class Song {
    private int id;
    private String title;

    private int singerId;
    private Genre genre;

    public Song(int id, String title, int singerId, Genre genre) {
        this.id = id;
        this.title = title;
        this.singerId = singerId;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getSingerId() {
        return singerId;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if( !(o instanceof Song)) return false;

        Song song = (Song) o;
        return this.id == song.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

class PlayList {
    private int id;
    private List<Song> songs;


    public PlayList(int id) {
        this.id = id;
        this.songs = new ArrayList<>();
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void  addSong(Song song){
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void remove(Song song){
        songs.remove(song);
    }

    public int playListSize(){
        return songs.size();
    }
}




class MusicPlayer {

    private PlayList playList;
    private Queue<Song> queue;
    private Optional<Song> currentSong;
    private Random rand;


    public MusicPlayer(PlayList playList) {
        this.playList = playList;
        queue = new LinkedList<>();
        rand = new Random();

    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public void playRandomSong(){
        int randomSongIndex = rand.nextInt(playList.playListSize());
        Song song = playList.getSongs().get(randomSongIndex);
        currentSong = Optional.of(song);
        queue.add(song);
        System.out.println("Playing The Following: " + currentSong.get().getTitle());
    }

    public void nextSong(){
        queue.poll();
        int currentSongIndex = playList.getSongs().indexOf(currentSong.get()) + 1;
        if(currentSongIndex < playList.playListSize()) {
            Song song = playList.getSongs().get(currentSongIndex);
            queue.add(song);
            currentSong = Optional.of(song);
            System.out.println("Switched To this song: " + song.getTitle());
        } else {
            System.out.println("Reached The end of the playlist");
        }
    }

    public List<Song> shuffle(){
        ArrayList<Song> shuffledList = new ArrayList<>();

        List<Song> copyList = new ArrayList<>();
        for(Song song : this.playList.getSongs()) {
            shuffledList.add(new Song(song.getId(),song.getTitle(),song.getSingerId(),song.getGenre()));
        }
        Collections.shuffle(shuffledList);
        return copyList;
    }

    public void stop(){
        System.out.println("pause song");
    }

    public void closeMediaPlayer(){
        System.out.println("closing....");
        queue.clear();
    }






}

public class main {
    public static void main(String[] args) {

        Song song = new Song(1, "All of the light", 41, Genre.ROCK);
        Song song1 = new Song(2, "Rock you", 41, Genre.ROCK);
        Song song2= new Song(3, "Two of us", 41, Genre.JAZZ);



        PlayList playList = new PlayList(1);

        playList.addSong(song);
        playList.addSong(song1);
        playList.addSong(song2);

        MusicPlayer musicPlayer = new MusicPlayer(playList);

        musicPlayer.playRandomSong();
        musicPlayer.nextSong();

       musicPlayer.shuffle();

    }

}
