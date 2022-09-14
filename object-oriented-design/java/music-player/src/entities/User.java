package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends BaseUser {

    public User(UUID id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

}
