package pack;

import static pack.Gardener1.text;

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
//        condition = Condition.stay;
    }
    void Move_to() {
//        condition = Condition.move_to;
        machine.Move(0, -60);
        temp++;
        if (temp==5){
            temp = 0;
            Water();
            text.setText("Watering");
        }
    }
    private void Water(){
//        condition = Condition.watering;
        temp++;
        if(temp==10){
            temp=0;
            Move_from();
        }
    }
    private void Move_from(){
//        condition = Condition.move_from;
        machine.Move(0, 60);
        temp++;
        if (temp == 5){
//            condition = Condition.stay;
            temp = 0;
        }
    }
//    public static enum Condition {stay, move_to, watering, move_from}
//    private Condition condition;
    private static String src = "./img/watering_machine.jpg";
    static ImagePanel machine;
    private int temp = 0;
}
