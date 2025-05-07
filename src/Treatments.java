public class Treatments {
    private static String type; // possible types: style, dye, accessory
    public static String[] options;
    //style: "curly", "flowy", "mohawk"
    // dye: "white", "red", "brown", "green", "blue", "purple",
    // accessory: "bunnyearsprite", "cloversprite", "orangesprite"
    public static int accessoryx;
    public static int accessoryy;

    public Treatments(String type, String[] options) {
        this.type = type;
        this.options = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            this.options[i] = options[i];
        }
    }

    public String getType() {
        return type;
    }

    public String[] getOptions() {
        return options;
    }


    public void applyTreatment(String selectedOption, Bird bird) {

        switch (type) {
            case "style":
                bird.treatments[0] = selectedOption; // Set treatment in array
                drawStyle(bird); // Draw the treatment
                break;

            case "curly":
            case "flowy":
            case "mohawk":
                bird.treatments[1] = selectedOption;
                drawDye(bird);
                break;

            case "accessory":
                bird.treatments[2] = selectedOption;
                break;
        }
    }

    public static void drawStyleMenu() {
        if (type.equals("style")) {
            for (int i = 0; i < options.length; i++) {
                if (i == 1) {
                    StdDraw.picture(995 / (options.length + 1) * (i + 1) + 20, 120, "image/" + options[i] + "white.png", 150, 150);
                    continue;
                }
                StdDraw.picture(995 / (options.length + 1) * (i + 1) + 20, 120, "image/" + options[i] + "white.png", 250, 250);
            }
        } else if (type.equals("curly") || type.equals("flowy") || type.equals("mohawk")) {
            for (int i = 0; i < 6; i++) {
                StdDraw.picture(995 / (options.length + 1) * (i + 1) + 20, 135, "image/" + type + options[i] + ".png", 170, 170);
            }
        } else if (type.equals("accessory")) {
            for (int i = 0; i < 3; i++) {
                StdDraw.picture(995 / (options.length + 1) * (i + 1) + 20, 135, "image/" + options[i] + ".png", 150, 150);
            }

        }
    }

    public void drawStyle(Bird bird) {
        String style = bird.getTreatment(0);
        int x = 0, y = 0; // Default coordinates

        switch (bird.getSpecies()) {
            case "pigeon":
                x = 1080 / 2 - 60; // default position
                y = 160 + 500; // default position
                break;

            case "lovebird":
                x = 1080 / 2 - 10; // default position
                y = 160 + 475; // default position
                break;

            case "finch":
                x = 1080 / 2 - 50; // default position
                y = 160 + 445; // default position
                break;
        }
        if (style.equals("mohawk") && !bird.getSpecies().equals("pigeon")){
            x -= 10; //shifting pos
            y += 30; //shifting pos
        }
        if (style.equals("flowy")){
            x += 90;
            y -= 120;
        }
        if (bird.getSpecies().equals("pigeon")){
            StdDraw.picture(x, y, "image/" + style + "white.png", 300, 300);
        } else {
            StdDraw.picture(x, y, "image/" + style + "white.png", 400, 400);
        }
    }

    public void drawDye(Bird bird) {
        String style = bird.getTreatment(0);
        String dye = bird.getTreatment(1);
        int x = 0, y = 0; // Default coordinates

        switch (bird.getSpecies()) {
            case "pigeon":
                x = 1080 / 2 - 60; // default position
                y = 160 + 500; // default position
                break;

            case "lovebird":
                x = 1080 / 2 - 10; // default position
                y = 160 + 475; // default position
                break;

            case "finch":
                x = 1080 / 2 - 50; // default position
                y = 160 + 445; // default position
                break;
        }
        if (style.equals("mohawk") && !bird.getSpecies().equals("pigeon")){
            x -= 10; //shifting pos
            y += 30; //shifting pos
        }
        if (style.equals("flowy")){
            x += 90;
            y -= 120;
        }
        if (bird.getSpecies().equals("pigeon")){
            StdDraw.picture(x, y, "image/" + style + dye + ".png", 300, 300);
        } else {
            StdDraw.picture(x, y, "image/" + style + dye + ".png", 400, 400);
        }
    }

    public void nudgeDrawDye(Bird bird, int yn) {
        String style = bird.getTreatment(0);
        String dye = bird.getTreatment(1);
        int x = 0, y = 0; // Default coordinates

        switch (bird.getSpecies()) {
            case "pigeon":
                x = 1080 / 2 - 60; // default position
                y = 160 + 500 + yn; // default position
                break;

            case "lovebird":
                x = 1080 / 2 - 10; // default position
                y = 160 + 475 + yn; // default position
                break;

            case "finch":
                x = 1080 / 2 - 50; // default position
                y = 160 + 445+ yn; // default position
                break;
        }
        if (style.equals("mohawk") && !bird.getSpecies().equals("pigeon")){
            x -= 10; //shifting pos
            y += 30; //shifting pos
        }
        if (style.equals("flowy")){
            x += 90;
            y -= 120;
        }
        if (bird.getSpecies().equals("pigeon")){
            StdDraw.picture(x, y, "image/" + style + dye + ".png", 300, 300);
        } else {
            StdDraw.picture(x, y, "image/" + style + dye + ".png", 400, 400);
        }
    }

    public void drawAccessory(Bird bird, int x, int y) {
        String accessory = bird.getTreatment(2);
        accessoryx = x;
        accessoryy = y;
        if (accessory.equals("cloversprite")){
            StdDraw.picture(accessoryx, accessoryy, "image/" + accessory + ".png", 50, 50);
        }
        if (accessory.equals("orangesprite")){
            StdDraw.picture(accessoryx, accessoryy, "image/" + accessory + ".png", 100, 100);
        }
        if (accessory.equals("bunnyearsprite")){
            StdDraw.picture(accessoryx, accessoryy, "image/" + accessory + ".png", 150, 150);
        }
    }
    public void nudgeDrawAccessory(Bird bird, int yn) {
        String accessory = bird.getTreatment(2);
        if (accessory.equals("cloversprite")){
            StdDraw.picture(accessoryx, accessoryy +yn, "image/" + accessory + ".png", 50, 50);
        }
        if (accessory.equals("orangesprite")){
            StdDraw.picture(accessoryx, accessoryy, "image/" + accessory + ".png", 100, 100);
        }
        if (accessory.equals("bunnyearsprite")){
            StdDraw.picture(accessoryx, accessoryy+yn, "image/" + accessory + ".png", 150, 150);
        }
    }
}