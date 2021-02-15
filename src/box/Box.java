package box;

import fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box implements Comparable<Box>{
    private List<Fruit> fruits;

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public void addAllFruitsFrom(List<Fruit> listF) {
        fruits.addAll(listF);
    }

    public Box() {
        fruits = new ArrayList<Fruit>();
    }
    public Box(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    private boolean isSameFruit(Fruit fruit) {
        if (fruits.size() == 0) {
            return true;
        }
        return fruits.get(0).getClass() == fruit.getClass();
    }

    private boolean isSameFruitsInBox(Box box) {
        if (box.getFruits().size() == 0) {
            return true;
        }
        return isSameFruit(box.getFruits().get(0));
    }

    public void addFruit(Fruit fruit) {
        if (isSameFruit(fruit))
            fruits.add(fruit);
    }

    public float getWeight() {
        return fruits.stream().map(Fruit::getWeight).reduce(Float::sum).orElse(0f);
    }

    public boolean compare(Box box) {
        return Math.abs(box.getWeight() - getWeight()) < 0.0001f;
    }

    public void pourTo(Box box) throws ClassCastException{
        if (isSameFruitsInBox(box)) {
            box.addAllFruitsFrom(fruits);
            fruits.clear();
        }
        else
            throw new ClassCastException();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits: " + fruits +
                '}';
    }

    @Override
    public int compareTo(Box o) {
        return Float.compare(getWeight(), o.getWeight());
    }
}
