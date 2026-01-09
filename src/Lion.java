public class Lion  {
    private  int clawLength;
    int wieght;
    int lenght;
    String name;
    boolean isAlive;
    String color;
    int x = 0;
    public Lion(int pwieght){
        pwieght = 100;
        clawLength =0;
        this.wieght = pwieght;
        lenght = 1;
        name = "Leo";
        isAlive = true;
        color = "Gold";

        int x = 0;

        this.x = 5;

        something(9);
    }

    public void something(int x){
        for(this.x = 0; x<6; x++){
            System.out.println("la");
        }
        System.out.println(x);
    }



   // @Override
    public void walk() {
        x =100;
        System.out.println("step step step");
    }

    //@Override
    public void eat() {
        System.out.println("nom nom");
    }

    public int getTuskLength(){
        return clawLength;
    }

    public void setTuskLength(int pTuskLength){
        clawLength = pTuskLength;
    }
}