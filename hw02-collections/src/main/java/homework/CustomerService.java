package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class CustomerService {

    // todo: 3. надо реализовать методы этого класса
    // важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer,String> treeMap;

    public CustomerService() {
        Comparator <Customer> comparator = Comparator.comparing (Customer::getScores);
        treeMap = new TreeMap<> (comparator);
    }

    public Map.Entry<Customer, String> getSmallest() {
        // Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return Map.Entry.copyOf (treeMap.firstEntry ());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return Map.Entry.copyOf (treeMap.higherEntry (customer));
    }


    public void add(Customer customer, String data) {
        treeMap.put(customer, data);
    }
}
