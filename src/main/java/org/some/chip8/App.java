package org.some.chip8;


import lombok.SneakyThrows;

public class App {

  public static void main(String[] args) {
    Chip8VirtualMachine virtualMachine = new Chip8VirtualMachine();
    virtualMachine.clearBuffer();

    int width = 10;
    int height = 15;

    byte[] frameBuffer = new byte[width * height];
    ConsoleDisplay consoleDisplay = new ConsoleDisplay(width, height);

    byte[][] digits = new byte[][]{Sprites.C, Sprites.TWO, Sprites.D, Sprites.F};

    for (byte[] aDigit : digits) {
      clearScreen();
      drawDigit(frameBuffer, width, aDigit);
      consoleDisplay.display(frameBuffer);
    }
  }

  private static void drawDigit(byte[] frameBuffer, int width, byte[] digit) {
    for (int i = 0; i < digit.length; i++) {
      frameBuffer[i * width] = (byte) (digit[i] & 8);
      frameBuffer[i * width + 1] = (byte) (digit[i] & 4);
      frameBuffer[i * width + 2] = (byte) (digit[i] & 2);
      frameBuffer[i * width + 3] = (byte) (digit[i] & 1);
    }
  }

  @SneakyThrows
  private static void clearScreen() {
    Thread.sleep(500);
    System.out.print("\033[H\033[2J");
    System.out.flush();
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
