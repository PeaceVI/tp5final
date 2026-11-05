package library.service;

import java.util.ArrayList;
import java.util.List;
import library.model.Lendable;

public class Customer {
    private final String name;
    private final List<Lendable> checkedOutItems = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public boolean checkOutItem(Lendable item) {
        return !checkedOutItems.contains(item) && item.borrow() && checkedOutItems.add(item);
    }

    public boolean returnItem(Lendable item) {
        return checkedOutItems.remove(item) && item.returnItem();
    }

    public String getName() {
        return name;
    }
}
