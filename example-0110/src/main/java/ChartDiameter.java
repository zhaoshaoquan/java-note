import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求无向无边图的直径
 * Created by zsq on 2019-06-09.
 */
public class ChartDiameter{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Integer groupNum = Integer.parseInt(scanner.nextLine());
        System.out.println(scanner.nextLine());

        List<int[][]> list = new ArrayList<>();
        for(int g=0;g<groupNum;g++){
            Integer nodeNum = Integer.parseInt(scanner.nextLine());
            int [][] nodeArray = new int[nodeNum-1][2];
            for(int i=0;i<nodeNum-1;i++){
                String str = scanner.nextLine();
                System.out.println(str);
                String[] strs = str.split(" ");
                nodeArray[i][0] = Integer.parseInt(strs[0]);
                nodeArray[i][1] = Integer.parseInt(strs[1]);
            }
        }

        System.out.println(list);
    }

}
