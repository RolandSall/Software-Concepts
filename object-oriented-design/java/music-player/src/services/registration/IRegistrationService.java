package services.registration;

import DTOs.CreateSingerDto;
import DTOs.CreateUserDto;
import entities.BaseUser;
import entities.Singer;
import entities.User;

public interface IRegistrationService {

    public User registerAsUser(CreateUserDto createUserDto);
    public Singer registerAsSinger(CreateSingerDto createSingerDto);
}
