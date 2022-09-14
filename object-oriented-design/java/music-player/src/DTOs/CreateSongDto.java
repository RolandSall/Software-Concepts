package DTOs;

import entities.Singer;

import java.util.List;

public class CreateSongDto {
    private String name;
    private List<Singer> singers;

    public CreateSongDto(String name, List<Singer> singers) {
        this.name = name;
        this.singers = singers;
    }

    public String getName() {
        return name;
    }

    public List<Singer> getSingers() {
        return singers;
    }
}
