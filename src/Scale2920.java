import java.util.Scanner;

public class Scale2920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAscending = false;
        boolean isDescending = false;

        int prevScale = scanner.nextInt();
        for(int i=0; i<7; i++){
            int currScale = scanner.nextInt();

            if(prevScale + 1 == currScale){
                isAscending = true;
            }else if(prevScale - 1 == currScale){
                isDescending = true;
            }else{
                System.out.println("mixed");
                return;
            }
            prevScale = currScale;
        }

        if(isAscending==true){
            System.out.println("ascending");
        }
        if(isDescending==true){
            System.out.println("descending");
        }
    }
}
