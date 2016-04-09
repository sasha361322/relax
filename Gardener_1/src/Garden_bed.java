/**
 * Created by Александр on 08.04.2016.1.
 * Есть объекты  «Поливочная машина», «Термометр», «Клумба с цветами».
 * Напишите пример программы (объект “Садовник”), которая при поступлении сигнала с датчика температуры
 * больше 30 градусов дает указание поливочной машине полить цветы. Поливочная машина может перемещаться
 * к указанной клумбе. Время полива одной клумбы составляет 10 минут, время перемещения 5 минут.
 * После полива клумба, вне зависимости от датчика температуры, не поливается 4 часа.
 */
public class Garden_bed implements Runnable{
    private Thermometer thermometer;
    private boolean needSomeWater;
    public Garden_bed(){
        thermometer = new Thermometer();
    }
    @Override
    public void run() {
        thermometer = new Thermometer();
        thermometer.run();
        while (true){
            needSomeWater = (thermometer.getTemperature()>30);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean CallForWateringMashine(){
        return needSomeWater;
    }
}