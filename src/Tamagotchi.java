import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public String getRandomWord() {
        if (words.isEmpty()) {
            System.out.println(name + " doesn't know any words yet!");
            return null; // Indicate no words learned
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public void hi(){
        Tamagotchi tamagotchi = new Tamagotchi(name);

        String randomWord = tamagotchi.getRandomWord();
        System.out.println(randomWord);
        tamagotchi.getRandomWord();
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



