package pack;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 Предусмотрите возможность в программе добавить несколько клумб,  для каждой свой датчик температуры и влажности.
 Исходную информацию о датчиках, контрольных значениях (температуры, влажности и др) и клумбах считывайте из файла.
 Исходная информация о времени срабатывания датчика со значением температуры (влажности и др.) считывается из файла для каждого датчика.
 Опишите выполненные изменения в программе.

 Как я понял изменения:
 1. "Исходную информацию о датчиках ... считывайте из файла" - есть файл в котором :
            -Количество клумб - N
            -Температура для полива
            -Влажность для полива
 2. "Исходная информация о времени ... считывается из файла для каждого датчика." - есть ещё N файлов аля
    15-31  15°С Влажность 35%
                    ----------------------------ИЗМЕНЕНИЯ В ПРОГРАММЕ-----------------------------
 Из файла settings считываются параметры, создаётся N клумб.
 Теперь может быть очередь в поливе между клумбами.
 Датчик влажности: так же, как и термометр со временем рандомит себе новое значение, которое не сиильно отличается от предыдущего.
 Условия для полива теперь такие: (температура>30) и (влажность<мин_влажность(
 То есть есть допустимый предел влажности. ((влажность<макс_влажность)&&(влажность>мин_влажность))
 При поливе влажность рандомно растёт.
 Если датчик засёк недопустимые показания, он их пишет в файл.

* */
public class Gardener2 {
    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(() -> {
            frame = new MyFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            timer = new Timer(100, e -> Tick());//Чтобы потестить ожидание 4 часов поставьте таймер на 1 милисекунду
            timer.start();
        });
        garden_bed = new Garden_bed();
        watering_mashine = new Watering_machine();
    }
    private static void Tick(){
        frame.repaint();
        garden_bed.Change();
        watering_mashine.Change();
        if(garden_bed.NeedSomeWater()){
            watering_mashine.Move();
        }
    }
    static MyFrame frame;
    static Clock clock;
    static Stop stop;
    static Timer timer;
    static JTextArea text;
    static final int Minute = 1000*60;//1000*60-милисекунд в секунде*секунд в минуте
    static Garden_bed garden_bed;
    static private Watering_machine watering_mashine;
    static SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
}