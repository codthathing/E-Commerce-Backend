package model;
import java.util.ArrayList;

public abstract class User {
  private final int id;
  private final String username;
  private final String email;
  private final Tag tag;

  public static ArrayList<User> users = new ArrayList<>();

  public User(String username, String email, Tag tag) {
    this.id = (int) (Math.random() * 1000);
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
    return String.format("id=%d, username=%s, email=%s, tag=%s", this.id, this.username, this.email, this.tag);
  }
}