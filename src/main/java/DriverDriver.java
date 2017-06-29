import java.util.Collections;
import java.util.LinkedList;

public class DriverDriver {

    public static void main(String[] args) {
        int howManyDrivers = 100;
        double average = 0;
        double infectionRate = 0.055;
        LinkedList<Double> runs = new LinkedList<>();
        int[] seeds = {4421, 4423, 4441, 4447, 4451, 4457, 4463, 4481, 4483, 4493, 4507, 4513, 4517, 4519, 4523, 4547, 4549, 4561, 4567,
                4583, 4591, 4597, 4603, 4621, 4637, 4639, 4643,	4649, 4651, 4657, 4663, 4673, 4679, 4691, 4703, 4721, 4723, 4729, 4733,	4751,
                4759, 4783, 4787, 4789, 4793, 4799, 4801, 4813, 4817, 4831, 4861, 4871, 4877, 4889, 4903, 4909, 4919, 4931, 4933, 4937,
                4943, 4951, 4957, 4967, 4969, 4973, 4987, 4993, 4999, 5003, 5009, 5011, 5021, 5023, 5039, 5051, 5059, 5077, 5081, 5087,
                5099, 5101, 5107, 5113, 5119, 5147, 5153, 5167, 5171, 5179, 5189, 5197, 5209, 5227, 5231, 5233, 5237, 5261, 5273, 5279};


        for (int i = 0; i < howManyDrivers; i++) {
            double result = Driver.drive(infectionRate, seeds[i]);
            average += result;
            runs.add(result);
        }

        Collections.sort(runs);

        runs.forEach(System.out::println);

        System.out.println("Infection rate: " + infectionRate * 100 + "%");
        System.out.println("Average: " + average / (double) howManyDrivers);
    }
}
