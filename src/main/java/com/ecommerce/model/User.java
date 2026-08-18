package model;
import java.util.ArrayList;
import java.util.UUID;

public abstract class User {
  private final UUID id;
  private final String username;
  private final String email;
  private final Tag tag;

  public static ArrayList<User> users = new ArrayList<>();

  public User(String username, String email, Tag tag) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.email = email;
    this.tag = tag;

    users.add(this);
  }

  public boolean canModerate() {
    return this.tag.getModerate();
  }

  @Override
  public String toString() {
    return String.format("id=%s, username=%s, email=%s, tag=%s", this.id, this.username, this.email, this.tag);
  }
}