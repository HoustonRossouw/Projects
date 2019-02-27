import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.Math.*;
import java.util.Formatter;

public class MyFile {

    public static void main(String[]args){

        try{
            //Compulsory Task 1
                   //&
            //Compulsory Task 2
            Formatter f = new Formatter("C:\\Users\\Sploosh69-PC\\Dropbox\\Houston Rossouw-19502\\Introduction to Software Engineering\\Task 12\\Completed task\\output.txt");
            File file = new File("C:\\Users\\Sploosh69-PC\\Dropbox\\Houston Rossouw-19502\\Introduction to Software Engineering\\Task 12\\Completed task\\input.txt");
            Scanner in = new Scanner(file);
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a number from 10 to 90: ");
            int px  = input.nextInt();
            while (in.hasNext()) {
                if (!in.hasNextLine()) {
                    break;
                }
                else{
                    String line = in.nextLine();
                    line = line.trim();
                    String[] functionType = line.split(":");
                    String actFunction = functionType[0];
                    actFunction = actFunction.trim();
                    //
                    String elements = functionType[1];//
                    String [] numArray = elements.split(",");//
                    //
                    int[] numbers = new int[numArray.length];
                    double count = 0;
                    float sum = 0;
                    int minNum = numbers[0];
                    int maxNum = numbers[0];

                    for (int i=0; i < numArray.length; i++){
                        numbers[i] = Integer.parseInt(numArray[i]);
                        count ++;
                    }
                    //MIN
                    for (int i =0; i < numbers.length;i++)
                    {
                        if(numbers[i] < minNum)
                        {
                            minNum += numbers[i];
                        }
                    }
                    //MAX
                    for (int i =0; i < numbers.length;i++)
                    {
                        if(numbers[i] > maxNum)
                        {
                            maxNum = numbers[i];
                        }
                    }
                    //AVG
                    for (int x:numbers)
                    {
                        //System.out.println(x);
                        sum = sum+x;
                    }
                    //MIN
                    if (actFunction.compareToIgnoreCase("min") == 0) {

                        f.format("%s %s %s %s %s","The min of",elements,"is",minNum,"\r\n");

                    }
                    //MAX
                    else if (actFunction.compareToIgnoreCase("max") == 0)
                    {
                        f.format("%s %s %s %s %s","The max of",elements,"is",maxNum,"\r\n");
                    }
                    //AVG
                    else if (actFunction.compareToIgnoreCase("avg") == 0)
                    {
                        f.format("%s %s %s %s %s","The avg of",elements,"is",sum/count,"\r\n");
                    }
                    //percentile P90
                    else if (actFunction.compareToIgnoreCase("P90")== 0)
                    {
                        float percentage = ((float) px) / 100;
                        double percentile = percentage*(count);
                        f.format("%s %s %s %s %s","The 90th percentile",elements,"is",Math.round(percentile),"\r\n");
                    }
                    //SUM
                    else if (actFunction.compareToIgnoreCase("Sum")== 0)
                    {
                        f.format("%s %s %s %s %s","The sum of",elements,"is",Math.round(sum),"\r\n");
                    }
                    //percentile P70
                    else if (actFunction.compareToIgnoreCase("P70")== 0)
                    {
                        float percentage = ((float) 70) / 100;
                        double percentile = percentage*(count);
                        f.format("%s %s %s %s %s","The 70th percentile",elements,"is",Math.round(percentile),"\r\n");
                    }
                }
            }
            in.close();
            f.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
        }

    }
}
