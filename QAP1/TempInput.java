package QAP1;

import java.util.Scanner;

public class TempInput {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the number of days: ");
            int numberOfDays = input.nextInt();

            double[] temperatures = new double[numberOfDays];

            for(int i = 0; i < numberOfDays; i++){
                System.out.println("Enter the temperature on day " + (i + 1) + ": ");
                temperatures[i] = input.nextDouble();
            }

            double averageTemp = AvgTemp.calcAverageTemp(temperatures);
            System.out.println("Average temperature: " + averageTemp);

            int daysAboveAverage = AvgTemp.daysAboveAverage(temperatures, averageTemp);
            System.out.println("Number of days above average: " + daysAboveAverage);
        }
    }
}
