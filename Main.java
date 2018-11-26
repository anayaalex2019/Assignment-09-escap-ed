import java.util.Scanner;

public class Main {

    //rooms and doors
    public static Boolean inFoyer = true ;
    public static Boolean inLibrary = false ;
    public static Boolean inConservatory = false ;
    public static Boolean foyerDoorLocked = true ;
    public static Boolean libraryDoorLocked = true ;
    public static Boolean conservatoryDoorLocked = true ;

    //items- Foyer
    public static Boolean chestOpen = false;
    public static Boolean hasMatches = false;
    public static Boolean foyerDoorOpen = false;

    //items- Library
    public static Boolean hasPen = false;
    public static Boolean hasBook = false;
    public static Boolean libraryDoorOpen = false;

    //items- Conservatory
    public static Boolean trumpet = false;
    public static Boolean piano = false;
    public static Boolean drum = false;
    public static Boolean conservatoryDoorOpen = false;

    //win?
    public static Boolean win = false;

    //turn timer
    public static int turn = 31;

    public static void main(String[] args) {
        begin();

    }
    public static void begin(){
    System.out.println("wakey wakey egggs and bakey, welcome to the game. Type 'commands' for a list of commands, " +
            "or type 'start' to begin the game" );
    input();

    }
    public static void input(){
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        menu(cmd);

    }
    public static void menu(String a){

        if (a.equals("start")){start();
        }   else if (a.equals("commands")){
            System.out.println("here is a list of verbs you can use: open, close, light, read, write, play, look, get");
            System.out.println("here is a list of directions you can use to move: north, south, east, west");
            System.out.println("Type 'commands' for a list of commands, or type 'start' to begin the game");
            input();
        }     else {
                System.out.println("Invalid input, try again!");
                input();}

        }

    public static void start(){

        System.out.print("you find yourself in a large foyer. there is a door to the north. to the west is a bench against the wall." +
                "\nto the east is a chest on the floor. In the center of the room is a large candle. the candle is unlit");

        turn();

    }

    public static void turn() {
        for (int i = 0; i < 31; i ++) {
            turn = turn - 1;
            if (turn == 0) {
                ending();
            }

            System.out.println("\nyou have " + turn + " turns remaining");
            System.out.println(">> ");

            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();

            if (inFoyer == true) {
                foyer(command);
            } else if (inLibrary == true) {
                library(command);
            } else if (inConservatory == true) {
                conservatory(command);
            }

        }

        }

    public static void foyer(String a){

        if (a.equals("look candle")) {System.out.println("The candle in the center of the room is not lit");}
        else if (a.equals("look bench")) {System.out.println("There is a bench on the western wall. There is a small note here");}
        else if (a.equals("read note")) {System.out.println("the note is written on a piece of fancy paper, it reads \'may my light show the way\'");}
        else if (a.equals("look chest")) {System.out.println("you see a chest that is closed and doesn't appear to be locked");}
        else if (a.equals("open chest")) {
            System.out.println("you open the chest. There is a box of matches here");
            chestOpen = true;
        }
        else if (a.equals("get matches") && (chestOpen == true)) {
            System.out.println("you take the box of matches out of the chest");
            hasMatches = true;
        }
        else if (a.equals("get matches") && (chestOpen == false)) {System.out.println("the chest is shut, maybe you should open it first");}
        else if (a.equals("light candle") && (hasMatches == true)) {
            System.out.println("you light the candle, and a fierce wind blows through the room, extinguishes the match but making \n the candle burn brighter you hear a loud metal grinding sound from the north");
            foyerDoorLocked = false;
        }
        else if (a.equals("light candle") && (hasMatches == false)) {System.out.println("you have nothing to light the candle with");}
        else if (a.equals("look door") && (foyerDoorLocked == true)) {System.out.println("the door to the north is closed and locked");}
        else if (a.equals("look door") && (foyerDoorLocked == false)) {System.out.println("the door to the north is closed, but unlocked");}
        else if (a.equals("open door") && (foyerDoorLocked) == true) {System.out.println("the door is locked, you should try unlocking it first");}
        else if (a.equals("open door") && (foyerDoorLocked) == false) {
            System.out.println("the north door is open");
            foyerDoorOpen = true;
        }
        else if (a.equals("go north") && (foyerDoorLocked == true && foyerDoorOpen == false )){System.out.println("the door is locked and shut, no way go get out");}
        else if (a.equals("go north") && (foyerDoorLocked == false && foyerDoorOpen == false)){System.out.println("you run north in excitement, but smash into the closed door, you should've checked if it was open");}
        else if (a.equals("go north") && (foyerDoorLocked == false && foyerDoorOpen == true)){
            System.out.println("you leave the foyer, the door behind you closes with a loud slam, and you hear the locking mechanism re-lock the door. you cannot return to the foyer \n you now find yourself in a library full of shelves of books. in the center of the room is a \n desk. on the desk is a pen and a scroll. There is a door to the north.");
        inFoyer = false;
        inLibrary = true;
        }
        else{System.out.println("nothing happens");}
    }

    public static void library(String a){

        if (a.equals("look books")){System.out.println("as you look through the books you notice one laying open. on the page of the book is written \"The Autobiography of ... \"");}
        else if (a.equals("look desk")){System.out.println("on the desk is a pen and a scroll");}
        else if (a.equals("look pen")){System.out.println("its just a pen");}
        else if (a.equals("read scroll")){System.out.println("on the scroll is written \"share your story\"");}
        else if (a.equals("look door") && (libraryDoorLocked == true)){System.out.println("the door to the north is closed and locked");}
        else if (a.equals("look door") && (libraryDoorLocked == false)){System.out.println("the door to the north is closed, but unlocked");}
        else if (a.equals("get pen")){
            System.out.println("you grab the pen");
            hasPen = true;
        }
        else if (a.equals("get book")){
            System.out.println("you grab the book");
            hasBook = true;
        }
        else if (a.equals("write name")&& (hasPen == true && hasBook == true)){
            System.out.println("you write your name in the book, and it flashes gold. a loud click sounds from the north, the door is unlocked");
            libraryDoorLocked = false;
        }
        else if (a.equals("write name") && (hasPen == false && hasBook == true)){System.out.println("you have nothing to write with");}
        else if (a.equals("write name")&& (hasPen == false && hasBook == false)){System.out.println("you are really confused bud");}
        else if (a.equals("write name") && (hasPen == true && hasBook == false)){System.out.println("on what?");}
        else if (a.equals("open door") && (libraryDoorLocked == true)){System.out.println("the door is locked");}
        else if (a.equals("open door") && (libraryDoorLocked == false)){
            System.out.println("the door is now open");
            libraryDoorOpen = true;
        }
        else if (a.equals("go north") && (libraryDoorLocked == true && libraryDoorOpen == false )){System.out.println("the door is locked and shut, no way go get out");}
        else if (a.equals("go north") && (libraryDoorLocked == false && libraryDoorOpen == false)){System.out.println("you run north in excitement, but smash into the closed door, you should've checked if it was open");}
        else if (a.equals("go north") && (libraryDoorLocked == false && libraryDoorOpen ==  true)){
            System.out.println("you leave the library, the door behind you closes with a loud slam, and you hear the locking mechanism re-lock the door. you cannot return to the library \n you walk into the conservatory and notice a large door to the north. there are three instruments here on a table, a trumpet, a drum, and a piano. \n there is a piece of sheet music on a stand in the center of the room. although empty, it has the phrase \" Timbre, Tone, and Time\" written on it.");
            inLibrary = false;
            inConservatory = true;
        }
        else{System.out.println("nothing happens");}
    }

    public static void conservatory(String a){

        if (a.equals("look trumpet")) {System.out.println("its a trumpet");}
        else if (a.equals("look drum")){System.out.println("its a drum");}
        else if (a.equals("look piano")){System.out.println("its a piano");}
        else if (a.equals("open door") && (conservatoryDoorLocked) == true) {System.out.println("the door is locked, you should try unlocking it first");}
        else if (a.equals("open door") && (conservatoryDoorLocked) == false) {
            System.out.println("the north door is open");
            conservatoryDoorOpen = true;
        }
        else if (a.equals("play trumpet") && ((piano == false) && (trumpet == false))){
            System.out.println("you played the trumpet, sounds pretty good");
            trumpet = true;
        }
        else if (a.equals("play trumpet") && ((piano == true) && (trumpet == false))){
            System.out.println("you played the trumpet, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play trumpet") && ((piano == false) && (trumpet == true))){
            System.out.println("you played the trumpet, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play trumpet") && ((piano == true) && (trumpet == true))){
            System.out.println("you played the trumpet, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
            conservatoryDoorLocked = true;
        }
        else if (a.equals("play piano") && ((trumpet == true) && (drum== false))){
            System.out.println("you played the piano, sounds pretty good");
            piano = true;
        }
        else if (a.equals("play piano") && ((trumpet == true) && (drum == true))){
            System.out.println("you played the piano, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
            conservatoryDoorLocked = true;
        }
        else if (a.equals("play piano") && ((trumpet == false) && (drum == true))){
            System.out.println("you played the piano, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play piano") && ((trumpet == false) && (drum == false))){
            System.out.println("you played the piano, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play drum") && ((trumpet == true)&&(piano == true))){
            System.out.println("you played the drums, sounds pretty good. after all of that wonderful music the look on the door breaks off, sounds like its open now");
            conservatoryDoorLocked = false;
            drum = true;
        }
        else if (a.equals("play drum") && ((trumpet == false) && (piano == false))){
            System.out.println("you played the drums, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play drum") && ((trumpet == true) && (piano == false))){
            System.out.println("you played the drums, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("play drum") && ((trumpet == false) && (piano == true))){
            System.out.println("you played the drums, could use a bit of practice");
            trumpet = false;
            piano = false;
            drum = false;
        }
        else if (a.equals("look door") && (conservatoryDoorLocked == true)){System.out.println("the door to the north is closed and locked");}
        else if (a.equals("look door") && (conservatoryDoorLocked == false)){System.out.println("the door to the north is closed, but unlocked");}
        else if (a.equals("go north") && (conservatoryDoorLocked == true && conservatoryDoorOpen == false )){System.out.println("the door is locked and shut, no way go get out");}
        else if (a.equals("go north") && (conservatoryDoorLocked == false && conservatoryDoorOpen == false)){System.out.println("you run north in excitement, but smash into the closed door, you should've checked if it was open");}
        else if (a.equals("go north") && (conservatoryDoorLocked == false && conservatoryDoorOpen ==  true)){
            System.out.println("you leave the conservatory, the door behind you closes with a loud slam, but the locking mechanism does'nt lock again because you broke it, \n I guess you could re enter but why would you do that? ");
            win = true;
            ending();
        }
        else {System.out.println("nothing happened");}

    }

    public static void ending(){

        if (win == true) {
        System.out.println("congrats! you won");
        } else if(win == false){
            System.out.println("sorry bud, you lost :(");
        }


    }
}
