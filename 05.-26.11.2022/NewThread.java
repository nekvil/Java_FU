
public class NewThread extends Thread {
    public void run(){
        for (int i = 1; i < 101; i++){
            System.out.println("Символ "+i);
        }
    }
}
