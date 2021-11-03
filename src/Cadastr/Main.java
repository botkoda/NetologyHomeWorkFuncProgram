package Cadastr;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int RECOMMEND_COST = 1000;
        final int MAX_LENGTH_DISTRICT = 6;
        final int MAX_WIDTH_DISTRICT = 8;
        final int LIMIT_GENERATE = 15;

        Cadastr cadastr = new Cadastr(MAX_LENGTH_DISTRICT, MAX_WIDTH_DISTRICT, RECOMMEND_COST, LIMIT_GENERATE);
        final int cost = costDistrict("Введите стоимость за квадратный метр(рекомендация: 80)", "Выввели не число");
        System.out.println("Сгенерированно " + LIMIT_GENERATE + " сделок, с макисмальной: " +
                "\nдлинной учатска - " + MAX_LENGTH_DISTRICT +
                "\nи широной - " + MAX_WIDTH_DISTRICT +
                "\n[длина, ширина,рекомендуемая стоимость] "
        );

        //группировка и вывод
        cadastr.groupingAllDistrict(cost, cadastr.setDistrictGeneratet()).forEach((x, y) -> {
            System.out.println(x);
            y.stream().forEach(y1 -> System.out.print(Arrays.toString(y1)));
            System.out.println();
        });
    }

    private static int costDistrict(String s1, String s2) {
        int s = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println(s1);
                String msg = scanner.nextLine();
                try {
                    s = Integer.parseInt(msg);
                    break;
                } catch (Exception e) {
                    System.out.println(s2);
                }
            }

        }
        return s;
    }
}
