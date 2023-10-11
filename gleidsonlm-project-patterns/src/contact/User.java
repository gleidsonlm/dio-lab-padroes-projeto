package contact;

import java.util.UUID;

public class User implements IUser {

    private UUID id;

    public User(String name, String email, String password) {
        // generate id with uuidv4
        this.id = UUID.randomUUID();
    }

    @Override
    public String getId() {
        return this.id.toString();
    }
}