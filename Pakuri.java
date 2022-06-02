public class Pakuri {
    private String species;
    private int attack, defense, speed;
    public Pakuri(String species) {
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }
    // Returns the species of this critter
    public String getSpecies() {
        return this.species;
    }
    // Returns the attack value for this critter
    public int getAttack() {
        return this.attack;
    }
    // Returns the defense value for this critter
    public int getDefense() {
        return this.defense;
    }
    // Returns the speed of this critter
    public int getSpeed() {
        return this.speed;
    }
    // Changes the attack value for this critter to newAttack
    public void setAttack(int attack) {
        this.attack = attack;
    }
    // Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
    public void evolve() {
        this.attack = attack * 2;
        this.defense = defense * 4;
        this.speed = speed * 3;
    }
}
