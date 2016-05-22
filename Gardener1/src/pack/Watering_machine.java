package pack;

import static pack.Gardener1.*;

/**
 * Created by Александр on 08.04.2016.1.
 * Есть объекты  «Поливочная машина», «Термометр», «Клумба с цветами».
 * Напишите пример программы (объект “Садовник”), которая при поступлении сигнала с датчика температуры
 * больше 30 градусов дает указание поливочной машине полить цветы. Поливочная машина может перемещаться
 * к указанной клумбе. Время полива одной клумбы составляет 10 минут, время перемещения 5 минут.
 * После полива клумба, вне зависимости от датчика температуры, не поливается 4 часа.
 */
class Watering_machine{
    Watering_machine(){
        machine = new ImagePanel(src, 50, 490);
        condition = Condition.stay;
    }
    void Move() throws InterruptedException {
        condition = Condition.move_to;
        Thread.sleep(5*MyTime);
        condition = Condition.watering;
        Thread.sleep(10*MyTime);
        condition = Condition.move_from;
        Thread.sleep(5*MyTime);
    }
    public static enum Condition {stay, move_to, watering, move_from}
    private Condition condition;
    private static String src = "./img/watering_machine.jpg";
    static ImagePanel machine;
}
