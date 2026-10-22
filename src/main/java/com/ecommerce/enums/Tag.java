package enums;

public enum Tag {
  ADMIN(true), MODERATOR(true), CUSTOMER(false);

  private final boolean canModerate;

  Tag(boolean canModerate) { this.canModerate = canModerate; };

  public boolean getModerate() { return this.canModerate; };
}
