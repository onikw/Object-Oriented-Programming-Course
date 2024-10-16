package agh.ics.oop;
import java.util.List;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[] args) {
        System.out.println("Start");
        List<MoveDirection> moves = parse(args);

    for (int i = 0; i < moves.size(); i++)
    {
        System.out.println(moves.get(i));
    }





        System.out.println("Stop");
    }

}
