import box.Box;
import fruits.Apple;
import fruits.Fruit;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static <T> void swapElements(List<T> list, int i, int j) {
        T temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

    private static <T> void swapElementsArray(T[] list, int i, int j) {
        T temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }

    private static <T> List<T> toArrayList(T[] list) {
        return Arrays.stream(list).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Box boxOranges1 = new Box();
        boxOranges1.addFruit(new Orange());
        boxOranges1.addFruit(new Orange());
        boxOranges1.addFruit(new Orange());
        Box boxOranges2 = new Box();
        boxOranges2.addFruit(new Orange());
        Box boxApples1 = new Box();
        boxApples1.addFruit(new Apple());
        boxApples1.addFruit(new Apple());

        System.out.println(boxOranges1);
        System.out.println(boxOranges2);
        System.out.println(boxApples1);

        System.out.println(boxOranges1.compare(boxApples1));
        System.out.println(boxOranges1.compare(boxOranges2));

        try {
            boxOranges2.pourTo(boxApples1);
        } catch (ClassCastException e) {
            System.out.println("Разные фрукты в коробках");
        }

        try {
            boxOranges1.pourTo(boxOranges2);
        } catch (ClassCastException e) {
            System.out.println("Разные фрукты в коробках");
        }

        System.out.println(boxOranges1);
        System.out.println(boxOranges2);
        System.out.println(boxApples1);

        try {
            boxApples1.pourTo(boxOranges1);
        } catch (ClassCastException e) {
            System.out.println("Разные фрукты в коробках");
        }

        System.out.println(boxOranges1);
        System.out.println(boxOranges2);
        System.out.println(boxApples1);

    }
}
