/**
 * Created by brianguthrie on 6/14/17.
 */

import java.util.Scanner;
public class Sticks {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        boolean turn = true;
        String playerTurn;
        boolean winner;
        processArgs();
        System.out.println();
        System.out.println("Player 1: " + player1.getLeftHand() + " " + player1.getRightHand());
        System.out.println("Player 2: " + player2.getLeftHand() + " " + player2.getRightHand());

        while ((player1.getLeftHand()!=0 && player1.getRightHand()!=0) ||
                (player2.getRightHand()!=0 && player2.getLeftHand()!=0)){
            if(turn==true){
                playerTurn = "Player 1's turn";
                System.out.println(playerTurn);
            }else{
                playerTurn = "Player 2's turn";
                System.out.println(playerTurn);
            }
            System.out.println("Choose Left Hand ('L') or Right Hand ('R') to do an action");
            if(input.hasNext()) {


                if (turn) {
                    String handChoice = input.next();
                    if (handChoice.equals("L")) {

                        System.out.println("You have chosen Left hand to do an action");
                        System.out.println("What action would you like to do? Attack Left ('L')? Attack Right ('R')? Or Split ('S')?");

                        String choice = input.next();

                        if (choice.equals("L")) {
                            System.out.println("You have chosen to attack the other Player's left hand");
                            move(player1, player2, "L", "L");
                        }
                        else if (choice.equals("R")) {
                            System.out.println("You have chosen to attack the other Player's right hand");
                            move(player1, player2, "L", "R");
                        }else if (choice.equals("S")){
                            System.out.println("You have Chosen to split the left hand value");
                            System.out.print("How much do you want to transfer to the right: ");
                            int transfer = input.nextInt();
                            player1.splitHand(handChoice,transfer);
                        }
                    }else if(handChoice.equals("R")){

                        System.out.println("You have chosen Right hand to do an action");
                        System.out.println("What action would you like to do? Attack Left ('L')? Attack Right ('R')? Or Split ('S')?");

                        String choice = input.next();

                        if (choice.equals("L")) {
                            System.out.println("You have chosen to attack the other Player's left hand");
                            move(player1, player2, "R", "L");
                        }
                        else if (choice.equals("R")) {
                            System.out.println("You have chosen to attack the other Player's right hand");
                            move(player1, player2, "R", "R");
                        }
                        else if (choice.equals("S")){
                            System.out.println("You have Chosen to split the right hand value");
                            System.out.print("How much do you want to transfer to the left: ");
                            int transfer = input.nextInt();
                            player1.splitHand(handChoice,transfer);
                        }
                    }
                    //if(input)
                }else{
                    String handChoice = input.next();

                    if(handChoice.equals("L")){

                        System.out.println("You have chosen Left hand to do an action");
                        System.out.println("What action would you like to do? Attack Left ('L')? Attack Right ('R')? Or Split ('S')?");

                        String choice = input.next();

                        if (choice.equals("L")) {
                            System.out.println("You have chosen to attack the other Player's left hand");
                            move(player2, player1, "L", "L");
                        }else if (choice.equals("R")) {
                            System.out.println("You have chosen to attack the other Player's right hand");
                            move(player2, player1, "L", "R");
                        }else if (choice.equals("S")){
                            System.out.println("You have Chosen to split the left hand value");
                            System.out.print("How much do you want to transfer to the right: ");
                            int transfer = input.nextInt();
                            player2.splitHand(handChoice,transfer);
                        }
                    }else if(handChoice.equals("R")){

                        System.out.println("You have chosen Right hand to do an action");
                        System.out.println("What action would you like to do? Attack Left ('L')? Attack Right ('R')? Or Split ('S')?");

                        String choice = input.next();

                        if (choice.equals("L")) {
                            System.out.println("You have chosen to attack the other Player's left hand");
                            move(player2, player1, "R", "L");
                        }
                        else if (choice.equals("R")) {
                            System.out.println("You have chosen to attack the other Player's right hand");
                            move(player2, player1, "R", "R");
                        }
                        else if (choice.equals("S")){
                            System.out.println("You have Chosen to split the right hand value");
                            System.out.print("How much do you want to transfer to the left: ");
                            int transfer = input.nextInt();
                            player2.splitHand(handChoice,transfer);
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("Player 1: " + player1.getLeftHand() + " " + player1.getRightHand());
            System.out.println("Player 2: " + player2.getLeftHand() + " " + player2.getRightHand());
            //break;
            turn = !(turn);
            if(player1.getLeftHand()==0 && player1.getRightHand()==0){
                break;
            }
            if(player2.getLeftHand()==0 && player2.getRightHand()==0){
                break;
            }
        }
        if(player1.getLeftHand()==0 && player1.getRightHand()==0){
            gameOver(2);
        }else if(player2.getLeftHand()==0 && player2.getRightHand()==0){
            gameOver(1);
        }
    }
    private static void processArgs(){
        System.out.println("Welcome to Sticks!");
        System.out.println("The rules of the game is to make the players hand reach 0");
        System.out.println("Each hand starts with 1 chip each");
        System.out.println("Just select the hand to do an action and then select which hand you want to attack");
        System.out.println("When selecting a hand, please label it as 'L' or 'R'");
    }
    private static void move(Player attacker, Player receiver, String playerHand, String receiverHand){
        if(playerHand.equals("L") && receiverHand.equals("L")){
            attacker.attackLeftHand(receiver, playerHand);
        }
        if(playerHand.equals("L") && receiverHand.equals("R")){
            attacker.attackRightHand(receiver, playerHand);
        }
        if(playerHand.equals("R") && receiverHand.equals("L")){
            attacker.attackLeftHand(receiver, playerHand);
        }
        if(playerHand.equals("R") && receiverHand.equals("R")){
            attacker.attackRightHand(receiver,playerHand);
        }
    }
    private static void gameOver(int player){
        if(player==1){
            System.out.println("Congratulations Player 1!!! You won!!!!");
        }
        if(player==2){
            System.out.println("Congratulations Player 2!!! You won!!!!");
        }
    }
}
