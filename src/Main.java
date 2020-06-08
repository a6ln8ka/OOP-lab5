import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        Text text = new Text(sc.nextLine());
        text.find_word_entrances();
        }
}