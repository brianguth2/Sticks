/**
 * Created by brianguthrie on 6/14/17.
 */
public class Player {

    private int leftHand;
    private int rightHand;

    public Player(){
        leftHand = 1;
        rightHand = 1;
    }
    public int getLeftHand(){
        return leftHand;
    }
    public int getRightHand() {
        return rightHand;
    }
    public void setLeftHand(int newValue){
        this.leftHand = newValue;
    }
    public void setRightHand(int newValue){
        this.rightHand = newValue;
    }

    public void attackLeftHand(Player receiver, String inputHand){
        int attackValue = 0;
        Player attacker = this;


        if(inputHand.equals("L")){
            attackValue = this.getLeftHand();
        } else if(inputHand.equals("R")){
            attackValue = this.getRightHand();
        }
        int leftValue = receiver.getLeftHand() + attackValue;

        receiver.setLeftHand(leftValue%5);

    }
    public void attackRightHand(Player receiver, String inputHand){
        int attackValue = 0;
        Player attacker = this;


        if(inputHand.equals("L")){
            attackValue = this.getLeftHand();
        } else if(inputHand.equals("R")){
            attackValue = this.getRightHand();
        }
        int leftValue = receiver.getRightHand() + attackValue;

        receiver.setRightHand(leftValue%5);
    }

    public void splitHand(String inputhand, int transfer){
        int leftValue = this.getLeftHand();
        int rightValue = this.getRightHand();
        if(inputhand.equals("L")){
            this.setRightHand((rightValue+transfer)%5);
            this.setLeftHand((leftValue-transfer)%5);
        }else if(inputhand.equals("R")){
            this.setLeftHand((leftValue+transfer)%5);
            this.setRightHand((rightValue-transfer)%5);
        }
    }
}
