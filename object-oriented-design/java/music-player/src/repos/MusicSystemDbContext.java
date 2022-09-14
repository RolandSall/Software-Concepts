package repos;

import DTOs.CreateSingerDto;
import DTOs.CreateSongDto;
import DTOs.CreateUserDto;
import entities.BaseUser;
import entities.Singer;
import entities.Song;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MusicSystemDbContext implements IMusicSystemDbContext {

    private List<User> users = new ArrayList<>();
    private List<Singer> singers = new ArrayList<>();

    private List<Song> songs = new ArrayList<>();


    @Override
    public User registerAsUser(CreateUserDto createUserDto) {
        User createdUser = new User(UUID.randomUUID(), createUserDto.getFirstName(), createUserDto.getLastName());
        users.add(createdUser);
        return createdUser;
    }

    @Override
    public Singer registerAsSinger(CreateSingerDto createSingerDto) {
        UUID uuid = UUID.randomUUID();
        registerAsUser(uuid, createSingerDto);
        Singer singer = new Singer(uuid, createSingerDto.getFirstName(), createSingerDto.getLastName());
        singers.add(singer);
        return singer;
    }

    private void registerAsUser(UUID uuid, CreateSingerDto createSingerDto) {
        users.add(new User(uuid, createSingerDto.getFirstName(), createSingerDto.getLastName()));
    }


    @Override
    public Song saveSong(CreateSongDto createSongDto) {
        Song newSong = new Song(UUID.randomUUID(), createSongDto.getName(), createSongDto.getSingers());

        songs.add(newSong);
        return newSong;
    }

    @Override
    public Song browseBySingerName(String name) {
        for (Song song : songs) {
            for (Singer singer : song.getSingers())
                if (singer.getFirstName().equalsIgnoreCase(name))
                    return song;
        }
        return null;

    }

    @Override
    public Song browseBySongName(String name) {
        for (Song song : songs) {
            if (song.getName().equalsIgnoreCase(name))
                return song;
        }
        return null;
    }
}
