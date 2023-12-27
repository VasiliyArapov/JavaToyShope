import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy("1", "Doll", 3);
        Toy toy2 = new Toy("2", "Car", 7);
        Toy toy3 = new Toy("3", "Puzzle", 4);

        Queue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);

        try {
            FileWriter fileWriter = new FileWriter("result.txt");

            int size_q = 0;
            for (Toy toy : toyQueue) {
                size_q += toy.getFrequency();
            }

            for (int i = 0; i < size_q; i++) {
                Toy toy = toyQueue.poll();
                String result = "Toy ID: " + toy.getId() + ", Name: " + toy.getName() + "\n";
                fileWriter.write(result);

                toy.changeFrequency();
                toyQueue.add(toy);
            }
            fileWriter.close();
            System.out.println("Result written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}