package QAP5;

import java.util.LinkedList;
import java.util.Queue;

class Animal implements Comparable<Animal> {
    private String animalInfo;
    private long timestamp;

    public Animal(String animalInfo) {
        this.animalInfo = animalInfo;
        this.timestamp = System.currentTimeMillis();
    }

    public String getAnimalInfo() {
        return animalInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Animal other) {
        return Long.compare(this.timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return animalInfo + " (timestamp: " + timestamp + ")";
    }
}

public class AnimalShelter {
    private Queue<Animal> catQueue;
    private Queue<Animal> dogQueue;

    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void enqueueCat(String catInfo) {
        catQueue.add(new Animal(catInfo));
    }

    public void enqueueDog(String dogInfo) {
        dogQueue.add(new Animal(dogInfo));
    }

    public Animal dequeueCat() {
        return catQueue.poll();
    }

    public Animal dequeueDog() {
        return dogQueue.poll();
    }

    public Animal dequeueAny() {
        Animal oldestCat = catQueue.peek();
        Animal oldestDog = dogQueue.peek();

        if (oldestCat == null && oldestDog == null) {
            System.out.println("No animals available!");
            return null;
        } else if (oldestDog == null) {
            return catQueue.poll();
        } else if (oldestCat == null) {
            return dogQueue.poll();
        } else {
            if (oldestCat.compareTo(oldestDog) <= 0) {
                return catQueue.poll();
            } else {
                return dogQueue.poll();
            }
        }
    }

    public static void main(String[] args) {

    }
}
