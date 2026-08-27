package model;

public enum TagEnum {
  ADMIN(false), MODERATOR(true);

  private final boolean canModerate;

  TagEnum(boolean canModerate) { this.canModerate = canModerate; };

  public boolean getModerate() { return this.canModerate; };
}
