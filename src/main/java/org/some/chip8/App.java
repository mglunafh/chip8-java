package org.some.chip8;


import java.util.Arrays;
import lombok.SneakyThrows;

public class App
{
    public static void main(String[] args) {
        Chip8VirtualMachine virtualMachine = new Chip8VirtualMachine();
        virtualMachine.clearBuffer();

        byte one = 0x1;

        int width = 8;
        int height = 5;

        byte[] frameBuffer = new byte[width * height];
        Arrays.fill(frameBuffer, 0, 4, one);
        frameBuffer[8] = one;
        Arrays.fill(frameBuffer, 2 * 8, 2 * 8 + 4, one);
        frameBuffer[4 * 7 - 1] = one;
        Arrays.fill(frameBuffer, 4 * 8, 4 * 8 + 4, one);


        ConsoleDisplay consoleDisplay = new ConsoleDisplay(width, height);

        int t = 3;
        while (t-- >= 0) {
            clearScreen();
            consoleDisplay.display(frameBuffer);
        }
    }

    @SneakyThrows
    private static void clearScreen() {
        Thread.sleep(500);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Thread.sleep(500);
    }

    private static void showChars() {
        for (int k = 0; k < 7; k++) {
            for (int i = 20 + 30 * k; i < 20 + 30 * (k + 1); i++) {
                System.out.printf("%4d", i);
            }
            System.out.println();
            for (int i = 20 + 30 * k; i < 20 + 30 * (k + 1); i++) {
                System.out.printf("%4c", (char) i);
            }
            System.out.println();
            System.out.println("----------------------------------------");
        }
    }
}
