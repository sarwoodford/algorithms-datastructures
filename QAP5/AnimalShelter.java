package QAP5;

import java.util.Queue;
import java.util.LinkedList;

public class AnimalShelter {
    private Queue<String> catQueue;
    private Queue<String> dogQueue;

    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void enqueueCat(String catInfo) {
        catQueue.add(catInfo);
    }

    public void enqueueDog(String dogInfo) {
        dogQueue.add(dogInfo);
    }

    public String dequeueCat() {
        return catQueue.poll();
    }

    public String dequeueDog() {
        return dogQueue.poll();
    }
}