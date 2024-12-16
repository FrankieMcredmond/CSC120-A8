import java.util.ArrayList;
import java.util.Scanner;

public class MonsterMash implements Contract{
    int size;
    int totalX;
    int totalY;
    int energy;
    ArrayList<String> inventory;
    ArrayList<String> actions;

    public MonsterMash(){
    this.size= 5;
    this.totalX=0;
    this.totalY=0;
    this.energy=100;
    this.inventory= new ArrayList<String>();
    this.inventory.add("Avocado");
    this.inventory.add("Cupcake");
    }






    public void grab(String item){
        this.inventory.add(item);
    }




    public void examine(String item){
        if (item.equals("Avocado")){
            System.out.println("This is THE AVOCADO OF POWER. Use it's super food properties to replenish your energy");
        }
        else if (item.equals("Cupcake")){
            System.out.println("This is THE ITTY BITTY CUPCAKE OF SHRINKING. Use it to shrink your size by 1 inch");
    
        }
        else {
            System.out.println("This object has no properties");
        }
        }
    }


    public void use(String item){
        if (item.equals("Avocado")){
            System.out.println();
            this.energy=100;
        }
        else if (item.equals("Cupcake")){
            System.out.println("\n You eat THE ITTY BITTY CUPCAKE OF SHRINKING. You shrink to "+this.shrink()+" inches");
    
        }
        else {
            System.out.println("This object has no properties");
        }
    }


    public boolean walk(String direction){
        if (direction.equals("FORWARD")){
            this.totalX+=5;
            return true;}
        if (direction.equals("BACK")){
            this.totalX-=5;
            return true;}
        else{ return false;}
    }

    public Number shrink(){
        this.size-=1;
        return this.size;

    }



    public boolean fly(int x, int y){
        this.totalX+=x;
        if ((this.totalY+y)>=0){
            this.totalY+=y;
            return true;}
        else{return false;}
    }
    
    public Number grow(){
        this.size+=1;
        return this.size;
    }
    public void rest(){}
    public void undo(){
        
    }

    public String drop(String item){
        return item;
    }












    public static void main(String[] args){
        
}