package QAP1;

public class AvgTemp{
    public static double calcAverageTemp(double[] temperatures){
        double sum = 0;
        for (double temp : temperatures){
            sum += temp;
        }
        return sum / temperatures.length;
    }

    public static int daysAboveAverage(double[] temperatures, double averageTemp){
        int count = 0;
        for(double temp : temperatures){
            if (temp > averageTemp){
                count++;
            }
        }
        return count;
    }
}