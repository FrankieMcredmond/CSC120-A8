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


    /**
     * Constructs an instance of the MonsterMash class
     */

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


    /**
     * adds item to inventory arraylist
     * @param item
     */
    public void grab(String item){
        this.actions.add("GRAB");
        this.inventory.add(item);
    }

    /**
     * Removes item from inventory
     * @param item
     */
    public String drop(String item){
        this.actions.add("DROP");
        this.inventory.remove(item);
        return item;
    }



    /**
     * Gives player description of item properties
     * @param item
     */
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

    /**
     * Lets players use special item properties
     * @param item
     */
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




    /**
     * Let's player move 5 units in a specific direction
     * @param direction
     * @return boolean whether action was successful
     * NOTE: Every time the walk method is used it depletes the players energy by 10 units
     */
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

    /**
     * Let's player move x units along the x axis, and y units along the y axis
     * @param x units player wants to move along x axis
     * @param y units player wants to move along y axis
     * @return  whether player was successful in flying or not, if returns false player couldn't fly all the way because of the ground
     */
    public boolean fly(int x, int y){
        this.actions.add("FLY");
        this.totalX+=x;
        if ((this.totalY+y)>=0){
            this.totalY+=y;
            return true;}
        else{
            this.totalY=0;
            return false;}
    }
    





    /**
     * Shrinks player by a factor of 1
     * 
     * @return int Player's current size
     */
    public Number shrink(){
        this.actions.add("SHRINK");
        this.size-=1;
        return this.size;

    }

    /**
     * Grows player by a factor of 1
     * 
     * @return int Player's current size
     */
    public Number grow(){
        this.actions.add("GROW");
        this.size+=1;
        return this.size;
    }

    



    /**
     * Replenishes Player's Energy to 100
     * 
     */
    public void rest(){
        this.actions.add("REST");
        this.energy=100;
    }



    /**
     * Undoes players most recent action
     * NOTE: the only actions able to be Undone are GRAB, FORWARD, BACK, SHRINK, and GROW 
     */
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
        else if (lastAction.equals("GROW")){
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
            else if (test.inventory.contains(selectItem)){
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
                else{Continue=false;}}
            else{System.out.println("Object not in inventory");}}
    
        Player.close();
    }

}
