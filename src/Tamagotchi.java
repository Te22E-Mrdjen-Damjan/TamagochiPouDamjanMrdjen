import java.util.ArrayList;
import java.util.List;

public class Tamagotchi {
    private int hunger;
    private int boredom;
    private List<String> words;
    private boolean isAlive;
    public String name;

    public Tamagotchi(String name) {
    this.name = name;
    hunger = 0;
    boredom = 0;
    words = new ArrayList<>();
    isAlive = true;
    }

    public void feed(){
        hunger--;
        hunger = Math.max(0, hunger);
        System.out.println(name+" is less hungry");

    }

    public void hi(){
        System.out.println("hi "+ name+ " !");
        reduceBoredom();
    }

    public void teach(String word){
        words.add(word);
        System.out.println(name+" has learned the word "+word);
        reduceBoredom();
    }

    public void tick(){
        hunger++;
        boredom++;
        reduceBoredom();
        if(hunger >= 10 || boredom >= 10){
            isAlive = false;
        }
    }

    public void printStats(){
        System.out.println("Name: " + name);
        System.out.println("Hunger: " + hunger);
        System.out.println("Boredom: " + boredom);
        System.out.println("Words: " + words);
        System.out.println("Is Alive: " + isAlive);
    }
    public boolean getAlive(){
        return isAlive;
    }

    private void reduceBoredom(){
        int boredomReduction = words.size()/2;
        boredom -= boredomReduction;
        boredom = Math.max(0, boredom);

    }

}



