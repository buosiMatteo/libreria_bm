package it.euris.libreriabm.exception;

public class IdMustNotBeNullException extends RuntimeException {

  public IdMustNotBeNullException() {
    super("Id must not be null. You send a DTO with an id");
  }

  public IdMustNotBeNullException(String message) {
    super(message);
  }

}
