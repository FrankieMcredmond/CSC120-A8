public class MonsterMash {
    Number size;
    Number fuel;
    int totalX;
    int totalY;
    Number energy;
    inventory





    void grab(String item){
        if (item=="food"){
            System.out.println("You found food! Eating now!");
            fuel=+1;
            System.out.println("fuel level:"+fuel);
        }
        else {
            System.out.println("You found a "+item+" :( would you like to keep it?");
        }
    }



    String drop(String item){}
    void examine(String item){}
    void use(String item){}
    boolean walk(String direction){}
    boolean fly(int x, int y){}
    Number shrink(){}
    Number grow(){}
    void rest(){}
    void undo(){}
}