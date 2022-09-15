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

    public Singer(int id, String firstName) {
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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Song)) return false;

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

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void remove(Song song) {
        songs.remove(song);
    }

    public int playListSize() {
        return songs.size();
    }
}

interface IPlaySongBehavior {

    Song nextSong(List<Song> playingSongs, int currentSongIndex);

}

class RepeatBehavior implements IPlaySongBehavior {

    @Override
    public Song nextSong(List<Song> playingSongs, int currentSongIndex) {
        Song nextSong = null;

        if (currentSongIndex + 1 < playingSongs.size()) {
            nextSong = playingSongs.get(currentSongIndex + 1);
        } else {
            // return to the first song
            nextSong = playingSongs.get(0);
        }


        return nextSong;
    }
}


class INoRepeatBehavior implements IPlaySongBehavior {

    @Override
    public Song nextSong(List<Song> playingSongs, int currentSongIndex) {
        Song nextSong = null;

        if (currentSongIndex + 1 < playingSongs.size()) {
            nextSong = playingSongs.get(currentSongIndex + 1);
        } else {
            nextSong = null;
            System.out.println("Reach The End of Your playList");
        }

        return nextSong;
    }
}

class MusicPlayer {

    private PlayList playList;
    private List<Song> playingSongs;

    private Song currentSong;

    private Random rand;

    private IPlaySongBehavior playSongBehavior = new RepeatBehavior();


    public MusicPlayer(PlayList playList) {
        this.playList = playList;
        playingSongs = new ArrayList<>(playList.getSongs());
        rand = new Random();

        currentSong = playingSongs.get(0);
    }

    public void setPlayList(PlayList playList) {
        currentSong = playList.getSongs().get(0);
        this.playingSongs = playList.getSongs();
        this.playList = playList;
    }

    public void pause() {
        //
    }

    public void play() {
        if (currentSong != null) {
            System.out.println("No song is chosen");
        }
        //
    }

    public void nextSong() {

        int currentIndexSong = playingSongs.indexOf(currentSong);
        currentSong = playSongBehavior.nextSong(playingSongs, currentIndexSong);
        play();


    }

    public void setPlaySongBehavior(IPlaySongBehavior playSongBehavior) {
        this.playSongBehavior = playSongBehavior;
    }


//    public void playRandomSong(){
//        int randomSongIndex = rand.nextInt(playList.playListSize());
//        Song song = playList.getSongs().get(randomSongIndex);
//        currentSong = Optional.of(song);
//        playingSongs.add(song);
//        System.out.println("Playing The Following: " + currentSong.get().getTitle());
//    }
//
//    public void nextSong(){
//        queue.poll();
//        int currentSongIndex = playList.getSongs().indexOf(currentSong.get()) + 1;
//        if(currentSongIndex < playList.playListSize()) {
//            Song song = playList.getSongs().get(currentSongIndex);
//            queue.add(song);
//            currentSong = Optional.of(song);
//            System.out.println("Switched To this song: " + song.getTitle());
//        } else {
//            System.out.println("Reached The end of the playlist");
//        }
//    }

    public void shuffle() {
        Collections.shuffle(playingSongs);

    }

    public void unShuffle() {
        this.playingSongs = new ArrayList<>(playList.getSongs());
    }

    public void stop() {
        System.out.println("pause song");
    }

    public void closeMediaPlayer() {
        System.out.println("closing....");
        //  queue.clear();
    }


}

public class main {
    public static void main(String[] args) {

        Song song = new Song(1, "All of the light", 41, Genre.ROCK);
        Song song1 = new Song(2, "Rock you", 41, Genre.ROCK);
        Song song2 = new Song(3, "Two of us", 41, Genre.JAZZ);


        PlayList playList = new PlayList(1);

        playList.addSong(song);
        playList.addSong(song1);
        playList.addSong(song2);

        MusicPlayer musicPlayer = new MusicPlayer(playList);

//        musicPlayer.playRandomSong();
//        musicPlayer.nextSong();
//
//        musicPlayer.shuffle();

    }

}
