package model;

public abstract class User {
  private final int id;
  private String username;
  private String email;

  public User(String username, String email) {
    this.id = (int) (Math.random() * 1000);
    this.username = username;
    this.email = email;
  }

  abstract void updateUsername();
  abstract void updateEmail();
  
  public String toString() {
    return String.format("id=%d, username=%s, email=%s", this.id, this.username, this.email);
  }
}
