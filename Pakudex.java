public class Pakudex {
    private int sizePakudex = 0;
    private Pakuri[] pakudex;
    // Default constructor
    public Pakudex() {
        pakudex = new Pakuri[20];
    }
    // Initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity) {
        pakudex = new Pakuri[capacity];
        for(int index = 0; index < getCapacity(); index++) {
            pakudex[index] = null;
        }
    }
    // Returns the number of critters currently being stored in the Pakudex
    public int getSize() {
        return this.sizePakudex;
    }
    // Returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity() {
        return pakudex.length;
    }
    // Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species added yet, this method should return null
    public String[] getSpeciesArray() {
        if(sizePakudex <= 0)
            return null;
        String[] speciesArr = new String[sizePakudex];
        for(int index = 0; index < sizePakudex; index++) {
            if(pakudex[index] != null)
                speciesArr[index] = pakudex[index].getSpecies();
        }
        return speciesArr;
    }
    // Returns  an  int  array  containing  the  attack,  defense,  and  speed  statistics  of  species  at  indices  0,  1, and 2 respectively; if species is not in the Pakudex, returns null
    public int[] getStats(String species) {
        // initialize variables
        int[] statistics = null;
        Pakuri reqPakuri = null;
        // if there are no species
        String[] speciesArr = getSpeciesArray();
        if(speciesArr == null)
            return null;
        // acquire required Pakuri
        for(int index = 0; index < sizePakudex; index++) {
            if(pakudex[index] != null) {
                String speciesPakuri = pakudex[index].getSpecies();
                if(speciesPakuri.contentEquals(species)) {
                    reqPakuri = pakudex[index];
                }
            }
        }
        // if the Pakuri is inexistent
        if(reqPakuri == null)
            return null;
        for(int index = 0; index < sizePakudex; index++) {
            if(speciesArr[index] != null) {
                if(speciesArr[index].contentEquals(species)) {
                    int a = reqPakuri.getAttack();
                    int d = reqPakuri.getDefense();
                    int s = reqPakuri.getSpeed();
                    statistics = new int[] {a, d, s};
                }
            }
        }
        // return the array of statistics
        return statistics;
    }
    // Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
    public void sortPakuri() {
        for(int index = 0; index < sizePakudex - 1; index++) {
            for(int i = index + 1; i < sizePakudex; i++) {
                if(pakudex[index] != null && pakudex[i] != null) {
                    String species1 = pakudex[index].getSpecies();
                    String species2 = pakudex[i].getSpecies();
                    if(species1.compareTo(species2) > 0) {
                        Pakuri placeHold = pakudex[i];
                        pakudex[i] = pakudex[index];
                        pakudex[index] = placeHold;
                    }
                }
            }
        }
    }
    // Adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species) {
        for(int index = 0; index < sizePakudex; index++) {
            if(pakudex[index] != null) {
                String exist = pakudex[index].getSpecies();
                if(exist.contentEquals(species))
                    return false;
            }
        }
        pakudex[sizePakudex] = new Pakuri(species);
        sizePakudex = sizePakudex + 1;
        return true;
    }
    //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
    public boolean evolveSpecies(String species) {
        Pakuri reqPakuri = null;
        if(sizePakudex <= 0)
            return false;
        for(int index = 0; index < sizePakudex; index++) {
            if(pakudex[index] != null) {
                String exist = pakudex[index].getSpecies();
                if(exist.contentEquals(species))
                    reqPakuri = pakudex[index];
            }
        }
        if(reqPakuri == null)
            return false;
        reqPakuri.evolve();
        return true;
    }
}
