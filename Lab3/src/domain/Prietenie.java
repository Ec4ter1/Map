package domain;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Prietenie extends Entity<UUID>{

    private Utilizator user1;
    private Utilizator user2;
    private LocalDateTime friendsFrom;

    public Prietenie(Utilizator user1, Utilizator user2){
        this.user1 = user1;
        this.user2 = user2;
        this.setId(UUID.randomUUID());
        friendsFrom = LocalDateTime.now();
    }

    public Utilizator getUser1() {
        return user1;
    }

    public Utilizator getUser2() {
        return user2;
    }

    public LocalDateTime getFriendsFrom() {
        return friendsFrom;
    }
}
