package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    public static void main(String[] args) {
        
        UI ui = new UI(new Scanner(System.in));
        ui.kaynnista();
    }
}
