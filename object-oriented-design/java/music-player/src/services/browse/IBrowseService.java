package services.browse;

import entities.Song;

public interface IBrowseService {

    Song  browseBySingerName(String name);

    Song  browseByName(String name);

}
