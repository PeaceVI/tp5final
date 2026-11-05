package library.model;

/**
 * Abstraction for every item that can be borrowed.
 * Services depend only on this interface (Dependency Inversion),
 * never on concrete classes such as Book.
 */
public interface Lendable {
    /** @return true if the item was available and is now borrowed. */
    boolean borrow();

    /** @return true if the item was borrowed and is now returned. */
    boolean returnItem();

    boolean isBorrowed();

    /** Human-readable description (replaces instanceof + cast in Library). */
    String getDescription();
}
