import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(10000);
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // Adds all numbers from 1 to 10000 to the array
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // divide 4 part
        int partSize = 2500;
        ArrayList<ArrayList<Integer>> numberParts = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i += partSize) {
            numberParts.add(new ArrayList<>(numbers.subList(i, Math.min(i + partSize, numbers.size()))));
        }

        // Find even and odd numbers with 4 different threads
        ArrayList<Thread> threads = new ArrayList<>();
        for (ArrayList<Integer> part : numberParts) {
            Thread evenThread = new Thread(() -> {
                for (Integer number : part) {
                    if (number % 2 == 0) {
                        synchronized (evenNumbers) {
                            evenNumbers.add(number);
                        }
                    }
                }
            });
            Thread oddThread = new Thread(() -> {
                for (Integer number : part) {
                    if (number % 2 != 0) {
                        synchronized (oddNumbers) {
                            oddNumbers.add(number);
                        }
                    }
                }
            });
            threads.add(evenThread);
            threads.add(oddThread);
            evenThread.start();
            oddThread.start();
        }

        // Wait till all threads are done
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Even: " + evenNumbers);
        System.out.println("Odd: " + oddNumbers);


    }
}
