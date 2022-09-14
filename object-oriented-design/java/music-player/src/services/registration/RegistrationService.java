package services.registration;

import DTOs.CreateSingerDto;
import DTOs.CreateUserDto;
import entities.Singer;
import entities.User;
import repos.IMusicSystemDbContext;

public class RegistrationService implements IRegistrationService{

    private IMusicSystemDbContext iMusicSystemDbContext;

    public RegistrationService(IMusicSystemDbContext iMusicSystemDbContext) {
        this.iMusicSystemDbContext = iMusicSystemDbContext;
    }

    @Override
    public User registerAsUser(CreateUserDto createUserDto) {
        return iMusicSystemDbContext.registerAsUser(createUserDto);
    }

    @Override
    public Singer registerAsSinger(CreateSingerDto createSingerDto) {
        return iMusicSystemDbContext.registerAsSinger(createSingerDto);
    }
}
