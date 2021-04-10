package org.some.chip8;

import java.util.Arrays;

public class Chip8VirtualMachine {

  public static final int DISPLAY_WIDTH = 64;
  public static final int DISPLAY_HEIGHT = 32;

  private static final byte ZERO = (byte) 0;

  private short indexRegister;
  private byte[] registers = new byte[16];
  private byte[] stack = new byte[8];

  private byte delayTimer;
  private byte soundTimer;
  private short programCounter;

  private byte[] frameBuffer = new byte[DISPLAY_WIDTH * DISPLAY_HEIGHT];

  private byte[] memory = new byte[4096];

  public void clearBuffer() {
    Arrays.fill(frameBuffer, ZERO);
  }
}
