public class Bird {
    String species;
    String name;
    String sprite;
    String[] treatments; //contains selected option for each type
    public Bird(String species, String name, String sprite){
        this.species = species;
        this.name = name;
        this.sprite = sprite;
        this.treatments = new String[3];
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    public String getTreatment(int i) {
        return treatments[i];
    }

    // 0. style: "curly", "flowy", "mohawk"
    // 1. dye: "white", "red", "brown", "green", "blue", "purple",
    // 2. accessory: "bunnyearsprite", "cloversprite", "orangesprite"
    public int judgment(){
        for (int i=0; i<3; i++){
        }
        int rating = 0;
        switch (species) {
            case "finch":
                switch (getTreatment(0)) {
                    case "curly": rating += 2; break;
                    case "wavy": rating += 1; break;
                    case "mohawk": rating += 3; break;
                }
                switch (getTreatment(1)) {
                    case "white":
                    case "brown": rating += 1; break;
                    case "red": rating += 2; break;
                    case "green":
                    case "blue":
                    case "purple": rating += 3; break;
                }
                switch (getTreatment(2)) {
                    case "bunnyearsprite": rating += 3; break;
                    case "cloversprite": rating += 1; break;
                    case "orangesprite": rating += 2; break;
                }
                break;
            case "pigeon":
                switch (getTreatment(0)) {
                    case "curly": rating += 2; break;
                    case "wavy": rating += 3; break;
                    case "mohawk": rating += 1; break;
                }
                switch (getTreatment(1)) {
                    case "white":
                    case "brown": rating += 1; break;
                    case "red": rating += 3; break;
                    case "green":
                    case "blue":
                    case "purple": rating += 2; break;
                }
                switch (getTreatment(2)) {
                    case "bunnyearsprite": rating += 1; break;
                    case "cloversprite": rating += 2; break;
                    case "orangesprite": rating += 3; break;
                }
                break;
            case "lovebird":
                switch (getTreatment(0)) {
                    case "curly": rating += 3; break;
                    case "wavy": rating += 1; break;
                    case "mohawk": rating += 3; break;
                }
                switch (getTreatment(1)) {
                    case "white":
                    case "brown": rating += 2; break;
                    case "green": rating += 3; break;
                    case "red":
                    case "blue":
                    case "purple": rating += 1; break;
                }
                switch (getTreatment(2)) {
                    case "bunnyearsprite": rating += 1; break;
                    case "cloversprite": rating += 2; break;
                    case "orangesprite": rating += 3; break;
                }
                break;
        }
        return rating;
    }
}
