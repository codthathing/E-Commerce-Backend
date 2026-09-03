package model;
import java.util.UUID;

public abstract class User {
  private final UUID id;
  private final String username;
  private final String email;
  private final String password;
  final TagEnum tag;

  public User(String username, String email, String password, TagEnum tag) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.email = email;
    this.password = password;
    this.tag = tag;
  }

  public UUID getId() {
    return this.id;
  }

  public String getPassword() {
    return this.password;
  }
  public String getUsername() {
    return this.username;
  }

  public boolean canModerate() {
    return this.tag.getModerate();
  }

  @Override
  public String toString() {
    return String.format("id=%s, username=%s, email=%s, tag=%s", this.id, this.username, this.email, this.tag);
  }
}