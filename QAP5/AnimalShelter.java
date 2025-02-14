package QAP5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);

        shelter.enqueueCat("Breed: Ragdoll - Name: Fluffy");
        shelter.enqueueCat("Breed: Russian Blue - Name: Whiskers");
        shelter.enqueueCat("Breed: Persian - Name: Garfield");

        shelter.enqueueDog("Breed: Golden Retriever - Name: Buddy");
        shelter.enqueueDog("Breed: French Bulldog - Name: Marley");
        shelter.enqueueDog("Breed: Beagle - Name: Bailey");

        while (true) {
            System.out.println("\nWelcome to the Animal Shelter!");
            System.out.println("Please choose an option:");
            System.out.println("1. Adopt the oldest cat");
            System.out.println("2. Adopt the oldest dog");
            System.out.println("3. Adopt the oldest animal (either cat or dog)");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Animal adoptedCat = shelter.dequeueCat();
                    if (adoptedCat != null) {
                        System.out.println("You adopted: " + adoptedCat);
                    } else {
                        System.out.println("No cats available to adopt.");
                    }
                    break;
                case 2:
                    Animal adoptedDog = shelter.dequeueDog();
                    if (adoptedDog != null) {
                        System.out.println("You adopted: " + adoptedDog);
                    } else {
                        System.out.println("No dogs available to adopt.");
                    }
                    break;
                case 3:
                    Animal adoptedAnimal = shelter.dequeueAny();
                    if (adoptedAnimal != null) {
                        System.out.println("You adopted: " + adoptedAnimal);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for visiting the shelter!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
