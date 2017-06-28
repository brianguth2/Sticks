/**
 * Created by brianguthrie on 6/14/17.
 */
public class Test {
    private static Player player1 = new Player();
    private static Player player2 = new Player();
    public static void main(String args[]){
        player1.attackLeftHand(player2, "L");
        System.out.println(player2.getLeftHand());
        player1.attackLeftHand(player2, "L");
        System.out.println(player2.getLeftHand());
        player1.attackLeftHand(player2, "L");
        System.out.println(player2.getLeftHand());
        player1.attackLeftHand(player2, "L");
        System.out.println(player2.getLeftHand());
        player1.setLeftHand(3);
        player1.attackLeftHand(player2, "L");
        System.out.println(player2.getLeftHand());
        player1.attackLeftHand(player2, "R");
        System.out.println(player2.getLeftHand());
    }
}
