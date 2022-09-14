package repos;

import DTOs.CreateSingerDto;
import DTOs.CreateSongDto;
import DTOs.CreateUserDto;
import entities.Singer;
import entities.Song;
import entities.User;


public interface IMusicSystemDbContext {

     User registerAsUser(CreateUserDto createUserDto);

     Singer registerAsSinger(CreateSingerDto createSingerDto);

     Song saveSong(CreateSongDto song);


    Song browseBySingerName(String name);

    Song browseBySongName(String name);
}
