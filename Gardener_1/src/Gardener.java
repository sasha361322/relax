/**
 * Created by Александр on 08.04.2016.1.
 * Есть объекты  «Поливочная машина», «Термометр», «Клумба с цветами».
 * Напишите пример программы (объект “Садовник”), которая при поступлении сигнала с датчика температуры
 * больше 30 градусов дает указание поливочной машине полить цветы. Поливочная машина может перемещаться
 * к указанной клумбе. Время полива одной клумбы составляет 10 минут, время перемещения 5 минут.
 * После полива клумба, вне зависимости от датчика температуры, не поливается 4 часа.
 */
public class Gardener {
    private static Garden_bed garden_bed;
    private static Watering_mashine watering_mashine;

    public static void main(String[] args) {
        garden_bed = new Garden_bed();
        watering_mashine = new Watering_mashine();
        garden_bed.run();
        watering_mashine.run();
        while (true){

        }
    }
}