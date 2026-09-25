package model;
import enums.Tag;

import java.util.UUID;

public class User {
  private final UUID id;
  private final String username;
  private final String email;
  private final String password;
  final Tag tag;

  public User(String username, String email, String password, Tag tag) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.email = email;
    this.password = password;
    this.tag = tag;
  }

  public String getPassword() {
    return this.password;
  }

  @Override
  public String toString() {
    return String.format("User(id=%s, username=%s, email=%s, tag=%s)", this.id, this.username, this.email, this.tag);
  }
}