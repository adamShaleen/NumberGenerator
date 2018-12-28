import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGeneratorService {

    public static void generate() {

        int[] threshHolds = {83000, 83000, 83000, 83000, 83000, 83000, 83000, 83000, 83000, 83000, 83000, 83000, 1000, 500, 250, 100, 50, 25, 10, 5};
        writeRandomNumbersToFile(threshHolds);
    }

    private static void writeRandomNumbersToFile(int[] threshHolds) {

        List<List<Integer>> listOfRandomNumberLists = NumberGeneratorService.createListOfRandomNumberLists(threshHolds);

        try (FileWriter file = new FileWriter("test.output.txt")) {

            for (List<Integer> randomList : listOfRandomNumberLists) {

                if (randomList.contains(20)) {
                    System.out.println(randomList);
                }

                for (int randomInt : randomList) {
                    file.write(String.valueOf(randomInt));
                    file.write("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<List<Integer>> createListOfRandomNumberLists(int[] threshHolds) {

        List<List<Integer>> listOfRandomNumberLists = new ArrayList<>();

        for (int threshold : threshHolds) {
            List<Integer> randomList = NumberGeneratorService.createRandomNumberList(threshold);
            listOfRandomNumberLists.add(randomList);
        }

        return listOfRandomNumberLists;
    }

    private static List<Integer> createRandomNumberList(int start) {

        Random random = new Random();
        int counter = start;
        List<Integer> randomList = new ArrayList<>();

        while (counter > 0) {
            randomList.add(random.nextInt((20 - 1) + 1) + 1);
            counter--;
        }
        return randomList;
    }
}