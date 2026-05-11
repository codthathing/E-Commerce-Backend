package model;

public class User {
  private final int id;
  private String username;
  private String email;
  private Tag tag;

  public User(String username, String email) {
    this(username, email, null);
  }

  public User(String username, String email, Tag tag) {
    this.id = (int) (Math.random() * 1000);
    this.username = username;
    this.email = email;
    this.tag = tag;
  }

  public boolean canModerate() {
    return this.tag.getModerate();
  }
  
  public String toString() {
    String base = String.format("User(id=%d, username=%s, email=%s", this.id, this.username, this.email);
    return this.tag != null ? base + String.format(", tag=%s", this.tag) + ")" : base + ")";
  }
}