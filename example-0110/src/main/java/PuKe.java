import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1
 * 1 2 3 4 5 6 7 8 9 10 11 12 13
 *
 * Created by zsq on 2019-06-09.
 */
public class PuKe{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true){
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            if(i++==0){
                continue;
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            String[] lines = line.split(" ");
            for (String dataLine : lines) {
                linkedList.addFirst(Integer.parseInt(dataLine));
            }
            LinkedList<Integer> preList = recover(linkedList);
            print(preList);
        }
    }

    private static void print(LinkedList<Integer> preList) {
        for (int i = 0; i < preList.size(); i++) {
            Integer integer = preList.get(i);
            System.out.print(integer);
            if (i < preList.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static LinkedList<Integer> recover(LinkedList<Integer> resultList) {
        LinkedList<Integer> predList = new LinkedList<>();
        while (resultList.size() > 0) {
            revocerOneCard(resultList, predList);
        }

        return predList;
    }

    private static void revocerOneCard(LinkedList<Integer> resultList, LinkedList<Integer> predList) {
        //1、取出桌上的牌
        int card = resultList.removeFirst();

        //2、将桌上的牌放到手上
        predList.addFirst(card);

        //3、将最后一张放到第一张
        if (resultList.size() > 0) {
            Integer lastCard = predList.removeLast();
            predList.addFirst(lastCard);
        }
    }

}
