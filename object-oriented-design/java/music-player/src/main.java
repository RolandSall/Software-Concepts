import DTOs.CreateSingerDto;
import DTOs.CreateSongDto;
import DTOs.CreateUserDto;
import entities.PlayList;
import entities.Singer;
import entities.Song;
import entities.User;
import repos.IMusicSystemDbContext;
import repos.MusicSystemDbContext;
import services.browse.BrowseService;
import services.browse.IBrowseService;
import services.playList.IPlayListService;
import services.playList.PlayListService;
import services.registration.IRegistrationService;
import services.registration.RegistrationService;
import services.singer.ISingerService;
import services.singer.SingerService;

import java.util.ArrayList;

public class main {


    public static void main(String[] args) {



//        IMusicSystemDbContext iMusicSystemDbContext = new MusicSystemDbContext();
//
//        IRegistrationService registrationService = new RegistrationService(iMusicSystemDbContext);
//        ISingerService singerService = new SingerService(iMusicSystemDbContext);
//        IBrowseService browseService = new BrowseService(iMusicSystemDbContext);
//        IPlayListService playListService = new PlayListService();
//
//        CreateUserDto userDto = new CreateUserDto("Roland", "Salloum");
//        CreateSingerDto singerDto = new CreateSingerDto("George", "Salloum");
//
//        // register user in system
//        User user = registrationService.registerAsUser(userDto);
//        Singer singer = registrationService.registerAsSinger(singerDto);
//
//        ArrayList<Singer> singers = new ArrayList();
//        singers.add(singer);
//
//
//        CreateSongDto createSongDto = new CreateSongDto("All of the Light", singers);
//
//
//        // create song
//        singerService.addSong(createSongDto);
//
//
//        // browse song
//        Song browsedSong = browseService.browseByName("All of the Light");
//
//        // create playlist
//        PlayList playList = new PlayList("rap songs", user);
//
//
//        ArrayList userPlayLists = new ArrayList();
//        userPlayLists.add(playList);
//
//        // initially empty
//        user.setPlayList(userPlayLists);
//
//        // get playList
//        PlayList rap_songs = user.getPlayListByName("rap songs");
//
//        //rap_songs.addSong(browsedSong);
//        playListService.addSong(rap_songs, browsedSong);
//
//        // play song
//        user.playSong(browsedSong);
//        // stop song
//        user.stopSong();
//
//        // shuffle playlist
//   //     user.shufflePlayList(rap_songs, new RandomShuffleBehavior());
//
//
//        singer.displayNotifications();
//        System.out.println("Current Songs in playlist: " + singer.getNumberOfSongsInPlayLists());
//
//        playListService.removeSong(rap_songs,browsedSong);
//        singer.displayNotifications();
//        System.out.println("Current Songs in playlist: " + singer.getNumberOfSongsInPlayLists());


    }
}
