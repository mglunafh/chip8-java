package org.some.chip8;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsoleDisplay {

  private final int width;
  private final int height;

  public void display(byte[] frameBuffer) {

    if (width * height != frameBuffer.length) {
      String message = String.format("Wrong buffer size: expected %dx%d = %d, got %d",
          width, height, width * height, frameBuffer.length);
      throw new IllegalArgumentException(message);
    }

    StringBuilder sb = new StringBuilder();
    repeat(sb, '-', width + 2).append("\n");
    for (int i = 0; i < height; i++) {
      sb.append('|');
      for (int j = 0; j < width; j++) {
        char ch = frameBuffer[i * width + j] == 0 ? ' ' : '#';
        sb.append(ch);
      }
      sb.append("|\n");
    }
    repeat(sb, '-', width + 2);
    System.out.println(sb.toString());
  }

  private static StringBuilder repeat(StringBuilder sb, char ch, int n) {
    for (int i = 0; i < n; i++) {
      sb.append(ch);
    }
    return sb;
  }
}
