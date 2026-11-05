package library.service;

import java.util.ArrayList;
import java.util.List;
import library.model.Lendable;

/**
 * Catalogue of lendable items. Depends only on the Lendable abstraction.
 */
public class Library {
    private final List<Lendable> items = new ArrayList<>();

    public void addItem(Lendable item) {
        items.add(item);
    }

    public void removeItem(Lendable item) {
        items.remove(item);
    }

    /** Bug fix: only returns items that are not currently borrowed. */
    public List<Lendable> getAvailableItems() {
        List<Lendable> available = new ArrayList<>();
        for (Lendable item : items) {
            if (!item.isBorrowed()) {
                available.add(item);
            }
        }
        return available;
    }

    /** Returns the descriptions; printing is the caller's responsibility (SRP). */
    public List<String> listAllItems() {
        List<String> descriptions = new ArrayList<>();
        for (Lendable item : items) {
            descriptions.add(item.getDescription());
        }
        return descriptions;
    }
}
