package services.browse;

import entities.Song;
import repos.IMusicSystemDbContext;

public class BrowseService implements IBrowseService{


    private IMusicSystemDbContext iMusicSystemDbContext;

    public BrowseService(IMusicSystemDbContext iMusicSystemDbContext) {
        this.iMusicSystemDbContext = iMusicSystemDbContext;
    }

    @Override
    public Song browseBySingerName(String name) {
        return iMusicSystemDbContext.browseBySingerName(name);
    }

    @Override
    public Song browseByName(String name) {
        return iMusicSystemDbContext.browseBySongName(name);
    }
}
