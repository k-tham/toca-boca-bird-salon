public class Project { // I will make this code more readable later...
    private static int[] coordinates = new int[2];
    public static void main(String[] args) {
        // initialize graphics
        StdDraw.setCanvasSize(1080, 720);
        StdDraw.setXscale(0, 1080);
        StdDraw.setYscale(0, 720);
        StdDraw.picture(1080 / 2, 720 / 2, "image/receptiondesk.jpg");


        // welcome menu
        StdDraw.picture(1080 / 2, 720 / 2, "image/menusprite.png");
        StdDraw.text(1080 / 2, 720 / 2 + 10, "Welcome to Toca Boca Bird Salon!");
        StdDraw.text(1080 / 2, 720 / 2 - 10, "Click anywhere to continue");
        clickCoordinates();
        StdAudio.play("sound/click.wav");

        // prompted to click a bird
        StdDraw.picture(1080 / 2, 720 / 2, "image/receptiondesk.jpg");
        StdDraw.picture(1080 / 2, 450, "image/menusprite.png", 300, 150);
        StdDraw.text(1080 / 2, 450, "Click to select a bird ⋌(˚͈⌔˚͈)⋋");
        // draw birds
        StdDraw.picture(1080 / 4, 160, "image/finchsprite.png", 300, 300);
        StdDraw.picture(1080 / 2, 160, "image/lovebirdsprite.png", 300, 300);
        StdDraw.picture(1080 * 3 / 4, 160, "image/pigeonsprite.png", 300, 300);
        clickCoordinates();
        StdAudio.play("sound/click.wav");

        //determine which bird was clicked
        StdDraw.picture(1080 / 2, 720 / 2, "image/receptiondesk.jpg");
        Bird selectedBird = null;

        // finch
        if (coordinates[0] <= 1080 / 4 + 150) {
            //replace bird sounds with chirp instead of click
            selectedBird = new Bird("finch", "Cheesecake", "image/finchsprite.png");
            StdDraw.picture(1080 / 2, 300, selectedBird.getSprite(), 500, 500);
        }

        // lovebird
        else if (coordinates[0] >= 1080 / 2 - 150 && coordinates[0] <= 1080 / 2 + 150) {
            selectedBird = new Bird("lovebird", "Kumquat", "image/lovebirdsprite.png");
            StdDraw.picture(1080 / 2, 300, selectedBird.getSprite(), 500, 500);
        }

        // pigeon
        else if (coordinates[0] >= 1080 * 3 / 4 - 150) {
            selectedBird = new Bird("pigeon", "Sigma",  "image/pigeonsprite.png");
            StdDraw.picture(1080 / 2, 300, selectedBird.getSprite(), 500, 500);
        }

        // user meets bird
        if (selectedBird.getSpecies().equals("finch")) {
            //First dialogue
            dialogue2line("Hihi hi!!! Nice to meet you!!", "Sorry if I'm a little jittery!!! I had 6 coffees today!!", selectedBird);
            //Second dialogue
            dialogue1line("I'm looking for something a little different..!!!", selectedBird);
            //Third dialogue
            dialogue2line("Maybe some layers? A little edge? Something spunky!!", "Hehehee!!! Give me the best you have!!!", selectedBird);
        }
        if (selectedBird.getSpecies().equals("lovebird")) {
            //First dialogue
            dialogue2line("Humm... hello... so shleeepy... zz", ".. honk shooo... shnore...", selectedBird);
            //Second dialogue
            dialogue2line("Mmmm I just need someting different, not too fancy..", "shnooore...", selectedBird);
            //Third dialogue
            dialogue2line("Shnore.. Hm! Sorry I'm a little... shleepy", "Something simple is ok..", selectedBird);
        }
        if (selectedBird.getSpecies().equals("pigeon")) {
            //First dialogue
            dialogue2line("Humph! Who are you?", "I have a reputation to maintain.", selectedBird);
            //Second dialogue
            dialogue2line("Do you think you have the ability to", "style me properly?", selectedBird);
            //Third dialogue
            dialogue2line("I’ve got standards, darling!", "Give me something to drop jaws.", selectedBird);
        }

        // Move to the styling part of the salon
        StdDraw.picture(1080 / 2, 720 / 2, "image/salonbg.jpg");
        StdDraw.picture(1080 / 2, 400, selectedBird.getSprite(), 500, 500);

        // Pick a hairstyle
        StdDraw.picture(1080 / 2, 150, "image/longmenu.png");
        StdDraw.text(1080 / 2, 230, "Select a hairstyle");
        // create a treatments instance in main class
        String[] styleOptions = new String[]{"curly", "flowy", "mohawk"};
        Treatments styleTreatment = new Treatments("style", styleOptions);
        // draw the treatments in the menu
        styleTreatment.drawStyleMenu();

        // determine based on coordinate of mouse click
        clickCoordinates();
        StdAudio.play("sound/click.wav");

        //determine which style was clicked
        String selectedStyle = null;

        // style 1
        if (coordinates[0] <= 1080 / 4 + 150) {
            selectedStyle = styleTreatment.options[0];
        }

        // style 2
        else if (coordinates[0] >= 1080 / 2 - 150 && coordinates[0] <= 1080 / 2 + 150) {
            selectedStyle = styleTreatment.options[1];
        }

        // style 3
        else if (coordinates[0] >= 1080 * 3 / 4 - 150) {
            selectedStyle = styleTreatment.options[2];
        }

        styleTreatment.applyTreatment(selectedStyle, selectedBird);


        // Pick a color
        StdDraw.picture(1080 / 2, 150, "image/longmenu.png");
        StdDraw.text(1080 / 2, 230, "Select a dye color");
        // create a treatments instance in main class
        String[] dyeOptions = new String[]{"white", "red", "brown", "green", "blue", "purple"};
        Treatments dyeTreatment = new Treatments(selectedStyle, dyeOptions);
        // draw the treatments in the menu
        dyeTreatment.drawStyleMenu();

        // determine based on coordinate of mouse click
        clickCoordinates();
        StdAudio.play("sound/click.wav");

        //determine which dye was clicked
        String selectedDye = null;


        // dye 1
        if (coordinates[0] <= 247.14 - 13.925) {
            selectedDye = dyeTreatment.options[0];
        }

        // dye 2
        else if (coordinates[0] >= 219.29 + 13.925 && coordinates[0] <= 389.29 - 13.925) {
            selectedDye = dyeTreatment.options[1];
        }

        //dye 3
        else if (coordinates[0] >= 361.43 + 13.925 && coordinates[0] <= 531.43 - 13.925) {
            selectedDye = dyeTreatment.options[2];
        }

        //dye 4
        else if (coordinates[0] >= 503.57 + 13.925 && coordinates[0] <= 673.57 - 13.925) {
            selectedDye = dyeTreatment.options[3];
        }

        //dye 5
        else if (coordinates[0] >= 645.71 + 13.925 && coordinates[0] <= 815.71 - 13.925) {
            selectedDye = dyeTreatment.options[4];
        }

        //dye 6
        else if (coordinates[0] >= 787.86 + 13.925) {
            selectedDye = dyeTreatment.options[5];
        }
        dyeTreatment.applyTreatment(selectedDye, selectedBird);

        //I'll probably add a speech bubble from the bird??

        // Pick an accessory
        StdDraw.picture(1080 / 2, 150, "image/longmenu.png");
        StdDraw.text(1080 / 2, 230, "Select an accessory");
        // create a treatments instance in main class
        String[] accessoryOptions = new String[]{"bunnyearsprite", "cloversprite", "orangesprite"};
        Treatments accessoryTreatment = new Treatments("accessory", accessoryOptions);
        // draw the treatments in the menu
        accessoryTreatment.drawStyleMenu();

        String selectedAccessory = null;

        // determine based on coordinate of mouse click
        clickCoordinates();
        StdAudio.play("sound/click.wav");

        // style 1
        if (coordinates[0] <= 1080 / 4 + 150) {
            selectedAccessory = accessoryTreatment.options[0];
        }

        // style 2
        else if (coordinates[0] >= 1080 / 2 - 150 && coordinates[0] <= 1080 / 2 + 150) {
            selectedAccessory = accessoryTreatment.options[1];
        }

        // style 3
        else if (coordinates[0] >= 1080 * 3 / 4 - 150) {
            selectedAccessory = accessoryTreatment.options[2];
        }

        // add in better text to prompt user to place accessory
        StdDraw.picture(1080 / 2, 150, "image/longmenu.png");
        StdDraw.picture(1080 / 2, 135, "image/" + selectedAccessory + ".png", 150, 150);
        StdDraw.text(1080 / 2, 230, "Click on the bird to place the accessory.");
        // determine based on coordinate of mouse click
        clickCoordinates();
        StdAudio.play("sound/click.wav");
        accessoryTreatment.applyTreatment(selectedAccessory, selectedBird);
        accessoryTreatment.drawAccessory(selectedBird, coordinates[0], coordinates[1]);

        //in between speech stage
        // Move to the decoration part of a salon
        StdDraw.picture(1080 / 2, 720 / 2, "image/salonbg.jpg");
        StdDraw.picture(1080 / 2, 400, selectedBird.getSprite(), 500, 500);
        dyeTreatment.drawDye(selectedBird);
        accessoryTreatment.drawAccessory(selectedBird, coordinates[0], coordinates[1]);
        dialogueNoName("Yay! You are complete! Time to show the client.");
        // judgment
        curtainAnimation(selectedBird, dyeTreatment, accessoryTreatment);
        StdDraw.disableDoubleBuffering();
        //calculate bird rating
        int rating = selectedBird.judgment();
        //dialogue based on rating
        String description = "";
        if (rating < 5) {
            description = "awful";
        }
        if (rating >= 5 && rating <= 7) {
            description = "great";
        }
        if (rating > 7) {
            description = "excellent";
        }
        String s1 = "";
        switch (selectedBird.getSpecies()) {
            case "finch":
                s1 = "Wow!!!! This really is " + description + "!!!!!!!";
                break;
            case "lovebird":
                s1 = "Honk shoo... mm... " + description + "....";
                break;
            case "pigeon":
                s1 = "Humph.. How interesting. Quite " + description + ".";
                break;
        }
        dialogue1line(s1, selectedBird);
        if (rating< 5) {
            s1 = "I'll be going now..";
        }
        if (rating >= 5 && rating <= 7) {
            s1 = "Thanks for the haircut!";
        }
        if (rating > 7) {
            s1 = "I will be coming back another time :]";
        }
        dialogue1line(s1, selectedBird);
        curtainAnimation2(selectedBird, dyeTreatment, accessoryTreatment, rating);
    }

    public static int[] clickCoordinates(){
        boolean acceptClick = true;
        while (acceptClick){
            if (StdDraw.isMousePressed()){
                int x = (int)StdDraw.mouseX();
                int y = (int)StdDraw.mouseY();
                coordinates[0] = x;
                coordinates[1] = y;
                acceptClick = false;
            }
        }
        return coordinates;
    }


    public static void curtainAnimation(Bird selectedBird, Treatments dyeTreatment, Treatments accessoryTreatment){
        StdDraw.enableDoubleBuffering();
        //curtain going down
        for (int i=1; i<=72/4; i++){
            StdDraw.clear();
            StdDraw.picture(1080 / 2, 720 / 2, "image/salonbg.jpg");
            StdDraw.picture(1080 / 2, 400, selectedBird.getSprite(), 500, 500);
            dyeTreatment.drawDye(selectedBird);
            accessoryTreatment.nudgeDrawAccessory(selectedBird, 0);
            StdDraw.picture(1080/2, 150, "image/menusprite.png", 450, 225);
            StdDraw.text(1080/2, 150, "Yay! You are complete! Time to show the client.");
            StdDraw.text(1080/2+450/2-80, 180-225/2, "Click to continue");
            StdDraw.picture(1080/2, 720+360-40*i, "image/curtain.jpg");
            StdDraw.show();
            StdDraw.pause(100);
        }
        StdDraw.pause(200);
        //curtain going up and scene change
        for (int i=1; i<=72/4; i++){
            StdDraw.clear();
            StdDraw.picture(1080 / 2, 720 / 2, "image/salonmirror.jpg");
            StdDraw.picture(1080 / 2, 720/2, selectedBird.getSprite(), 500, 500);
            dyeTreatment.nudgeDrawDye(selectedBird, -40);
            accessoryTreatment.nudgeDrawAccessory(selectedBird, -40);
            StdDraw.picture(1080/2, 360+40*i, "image/curtain.jpg");
            StdDraw.show();
            StdDraw.pause(100);
        }
        StdDraw.disableDoubleBuffering();
        StdDraw.pause(50);
    }

    public static void curtainAnimation2(Bird selectedBird, Treatments dyeTreatment, Treatments accessoryTreatment, int rating) {
        StdDraw.enableDoubleBuffering();
        //curtain going down
        for (int i = 1; i <= 72 / 4; i++) {
            StdDraw.clear();
            StdDraw.picture(1080 / 2, 720 / 2, "image/salonmirror.jpg");
            StdDraw.picture(1080 / 2, 720/2, selectedBird.getSprite(), 500, 500);
            dyeTreatment.nudgeDrawDye(selectedBird, -40);
            accessoryTreatment.nudgeDrawAccessory(selectedBird, -40);
            StdDraw.picture(1080/2, 720+360-40*i, "image/curtain.jpg");
            StdDraw.show();
            StdDraw.pause(100);
        }
        StdDraw.disableDoubleBuffering();
        StdDraw.picture(1080 / 2, 720 / 2, "image/menusprite.png");
        StdDraw.text(1080 / 2, 720 / 2, "The end.");

    }

    public static void dialogue1line(String s, Bird selectedBird){
        StdDraw.picture(1080/2, 150, "image/menusprite.png", 450, 225);
        StdDraw.text(1080/2, 150, s);
        StdDraw.text(1080/2+450/2-80, 180-225/2, "Click to continue");
        switch (selectedBird.getName()){
            case "Kumquat":
            case "Cheesecake":
                StdDraw.text(1080/2-450/2+70, 120+225/2, selectedBird.getName());
                break;
            case "Sigma":
                StdDraw.text(1080/2-450/2+60, 110+225/2,selectedBird.getName());
                break;
        }
        clickCoordinates();
        StdAudio.play("sound/click.wav");
    }

    public static void dialogue2line(String s1, String s2, Bird selectedBird){
        StdDraw.picture(1080/2, 150, "image/menusprite.png", 450, 225);
        StdDraw.text(1080/2, 160, s1);
        StdDraw.text(1080/2, 140, s2);
        StdDraw.text(1080/2+450/2-80, 180-225/2, "Click to continue");
        switch (selectedBird.getName()){
            case "Kumquat":
            case "Cheesecake":
                StdDraw.text(1080/2-450/2+70, 120+225/2, selectedBird.getName());
                break;
            case "Sigma":
                StdDraw.text(1080/2-450/2+60, 110+225/2,selectedBird.getName());
                break;

        }
        clickCoordinates();
        StdAudio.play("sound/click.wav");
    }

    public static void dialogueNoName(String s1){
        StdDraw.picture(1080/2, 150, "image/menusprite.png", 450, 225);
        StdDraw.text(1080/2, 150, s1);
        StdDraw.text(1080/2+450/2-80, 180-225/2, "Click to continue");
        clickCoordinates();
        StdAudio.play("sound/click.wav");
    }

}