public class Car {
    int maxSpeed;
    String color;
    int weight;
    String brand;
    String body;

    void say() {
        System.out.println(brand + " Forever. Наш авто имеет максимальную скорость равную " + maxSpeed + " км, "
                + color + " цвета, весит " + weight + " кг и тип кузова " + body + "."
        );
    }

}
