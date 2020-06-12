//Создать консольное приложение, удовлетворяющее требованиям:
//
//Каждый класс должен иметь отражающее смысл название и информативный состав.
//Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
//Наследование должно применяться только тогда, когда это имеет смысл.
//Классы должны быть грамотно разложены по пакетам
//Консольное меню должно быть минимальным.
//Для хранения параметров инициализации можно использовать файлы.

//6. Камни. Определить иерархию драгоценных и
//полудрагоценных камней. Отобрать камни для ожерелья.
//Подсчитать общий вес (в каратах) и стоимость.
//Провести сортировку камней ожерелья на основе ценности.
//Найти камни в ожерелье, соответствующие заданному диапазону параметров прозрачности.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Necklace extends ArrayList<Stone> {
    float totalCost;
    int totalKarat;

    public double getTotalCost() {
        return totalCost;
    }

    public int getTotalKarat() {
        return totalKarat;
    }

    public static void main(String[] args) {
        Necklace necklace = new Necklace();
        try {
            Scanner scanner = new Scanner(new File("src\\Stones.txt"));
            while (scanner.hasNext()) {
                necklace.add(new Stone(scanner.next(), scanner.next(), scanner.nextByte(), scanner.nextFloat(), scanner.next()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        necklace.removeIf(s -> s.getKarat() < 2 | s.getKarat() > 8);
        Collections.sort(necklace);
        System.out.println();
        System.out.println(necklace);

        System.out.print("Transparent stones in necklace: ");
        for (Stone s : necklace) {
            necklace.totalCost += s.getStonePrice();
            necklace.totalKarat += s.getKarat();
            if (s.transparency.contains("parent")) {
                System.out.print(s.getName() + ", ");
            }
        }

        System.out.println("\nNecklace cost is " + necklace.getTotalCost() + " $" +
                "\nNecklace total weight is " + necklace.getTotalKarat() + " karats");
    }
}







