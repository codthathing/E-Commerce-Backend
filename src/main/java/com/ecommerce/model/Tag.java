package model;

public enum Tag {
  ADMIN(false), MODERATOR(true);

  private final boolean canModerate;

  Tag(boolean canModerate) { this.canModerate = canModerate; };

  public boolean getModerate() { return this.canModerate; };
}
