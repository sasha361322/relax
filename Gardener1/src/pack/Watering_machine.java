package pack;

import java.util.Date;

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
    void Move() {
        condition = Condition.move_to;
        start = clock.getTime().getTime();
    }
    void Change(){
        long clock_time = clock.getTime().getTime();
        if(condition == Condition.move_to){
            machine.Move(0, -2);
            if ((clock_time-start)>=Minute*5){
                condition = Condition.watering;
                start = clock_time;
                text.append(".\nwatering from "+df.format(new Date(start))+" to "+df.format(new Date(start+10*Minute)));
            }
        }
        else  if (condition == Condition.watering){
            if (clock_time-start>=Minute*10){
                garden_bed.wasJustWatered();
                condition = Condition.move_from;
                start = clock_time;
            }
        }
        else if(condition == Condition.move_from){
            machine.Move(0, 2);
            if ((clock_time-start)>=Minute*5){
                condition = Condition.stay;
            }
        }
    }
    private long start=0;
    private enum Condition {stay, move_to, watering, move_from}
    private Condition condition;
    private static String src = "./img/watering_machine.jpg";
    static ImagePanel machine;
}
