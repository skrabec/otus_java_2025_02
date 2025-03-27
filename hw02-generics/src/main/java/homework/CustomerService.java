package homework;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {
    private final NavigableMap<Customer, String> customers = new TreeMap<>((c1, c2) -> c1.getScores() != c2.getScores()
        ? Long.compare(c1.getScores(), c2.getScores())
        : Long.compare(c1.getId(), c2.getId()));

    public Map.Entry<Customer, String> getSmallest() {
        if (customers.isEmpty()) {
            return null;
        }
        return copyEntry(customers.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copyEntry(customers.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }

    private Map.Entry<Customer, String> copyEntry(Map.Entry<Customer, String> entry) {
        if (entry == null) {
            return null;
        }

        final Customer originalCustomer = entry.getKey();
        final Customer clonedCustomer = new Customer(
            originalCustomer.getId(),
            originalCustomer.getName(),
            originalCustomer.getScores()
        );

        return Map.entry(clonedCustomer, entry.getValue());
    }
}