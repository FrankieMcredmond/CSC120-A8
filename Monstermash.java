import java.util.ArrayList;
import java.util.Scanner;

public class MonsterMash implements Contract{
    public  int size;
    public int totalX;
    public int totalY;
    public int energy;
    public boolean restart;
    ArrayList<String> inventory;
    ArrayList<String> actions;

    public MonsterMash(){
    this.size= 5;
    this.totalX=0;
    this.totalY=0;
    this.energy=100;
    this.restart=false;
    this.inventory= new ArrayList<String>();
    this.actions= new ArrayList<String>();
    this.inventory.add("Avocado");
    this.inventory.add("Cupcake");
    }



    public void grab(String item){
        this.actions.add("GRAB");
        this.inventory.add(item);
    }


    public String drop(String item){
        this.actions.add("DROP");
        this.inventory.remove(item);
        return item;
    }




    public void examine(String item){
        this.actions.add("EXAMINE");
        if (item.equals("Avocado")){
        System.out.println("This is THE AVOCADO OF POWER. Use it's super food properties to replenish your energy");
    }
        else if (item.equals("Cupcake")){
            System.out.println("This is THE ITTY BITTY CUPCAKE OF SHRINKING. Use it to shrink your size by 1 inch");
    }
        else{ System.out.println("This object has no properties");}
    }


    public void use(String item){
        this.actions.add("USE");
        if (item.equals("Avocado")){
            System.out.println("The AVOCADO OF POWER has increased your energy to 100");
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
            this.actions.add("FORWARD");
            this.totalX+=5;
            this.energy-=10;
            return true;}
        if (direction.equals("BACK")){
            this.actions.add("BACK");
            this.totalX-=5;
            this.energy-=10;
            return true;}
        else{ return false;}
    }

    public boolean fly(int x, int y){
        this.actions.add("FLY");
        this.totalX+=x;
        if ((this.totalY+y)>=0){
            this.totalY+=y;
            return true;}
        else{return false;}
    }
    






    public Number shrink(){
        this.actions.add("SHRINK");
        this.size-=1;
        return this.size;

    }

    public Number grow(){
        this.actions.add("GROW");
        this.size+=1;
        return this.size;
    }

    



    
    public void rest(){
        this.actions.add("REST");
        this.energy=100;
    }




    public void undo(){
        String lastAction= this.actions.get(this.actions.size()-1);
        if (lastAction.equals("GRAB")){
            this.inventory.remove(this.inventory.size()-1);
        }
        else if (lastAction.equals("FORWARD")){
            this.totalX-=5;
            this.energy+=10;
            
        }
        else if (lastAction.equals("BACK")){
            this.totalX+=5;
            this.energy+=10;
            
        }
        else if (lastAction.equals("SHRINK")){
            this.size+=1;
        }
        else if (lastAction.equals("GRAB")){
            this.size-=1;
        }
        else{System.out.println("Your last action cannot be undone");}
        
    }












    public static void main(String[] args){
        MonsterMash test= new MonsterMash();
        Scanner Player= new Scanner(System.in);
        test.grab("potato");

       


        System.out.println(test.fly(5, 7));

        test.undo();

        System.out.println(test.walk("FORWARD"));
        System.out.println(test.energy);

        System.out.println("YOU GREW to "+test.grow()+" inches");


        System.out.println("\n \nINVENTORY");
        for(int i = 0; i < test.inventory.size(); i++) {   
            System.out.print("\n"+ test.inventory.get(i));
        }


        boolean Continue =true;
        while (Continue){
            System.out.println("\n\n select an item or type EXIT to leave the inventory");
            String selectItem= Player.nextLine();
            if (selectItem.equals("EXIT")){
                Continue=false;
            }
            else{
            System.out.println("\n\nYou've selected "+ selectItem+". Would you like to USE, EXAMINE, or DROP this item?");
                String selectOption= Player.nextLine();
                if (selectOption.equals("USE")){
                    test.use(selectItem);
                }
                else if (selectOption.equals("EXAMINE")){
                    test.examine(selectItem);
                }
                else if (selectOption.equals("DROP")){
                    test.drop(selectItem);
                }
                else{Continue=false;}}}
    
        Player.close();
    }

}
