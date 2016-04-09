import java.util.Random;

/**
 * Created by Александр on 08.04.2016.1.
 * Есть объекты  «Поливочная машина», «Термометр», «Клумба с цветами».
 * Напишите пример программы (объект “Садовник”), которая при поступлении сигнала с датчика температуры
 * больше 30 градусов дает указание поливочной машине полить цветы. Поливочная машина может перемещаться
 * к указанной клумбе. Время полива одной клумбы составляет 10 минут, время перемещения 5 минут.
 * После полива клумба, вне зависимости от датчика температуры, не поливается 4 часа.
 */
public class Thermometer implements Runnable{
    private int temperature;
    public Thermometer(){
        Random rnd = new Random();
        temperature = rnd.nextInt(50);
    }
    public int getTemperature(){
        return temperature;
    }
    @Override
    public void run() {
        Random rnd = new Random();
        temperature = rnd.nextInt(50);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
