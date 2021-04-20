package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringWriterTest {
  StringWriter writer;

  @BeforeEach
  public void init() {
     writer = new StringWriter();
  }

  @Test
  public void Canary() {
    assertTrue(true);
  }

  @Test
  public void writeNothingToStringWriter() {
    assertEquals("", writer.getContent());
  }


  @Test
  public void writeStringToWriter() {
    writer.write("Hello world!");

    assertEquals("Hello world!", writer.getContent());
  }

  @Test
  public void writeStringTwiceToWriter() {
    writer.write("Hello world!");
    writer.write("Hello world!");

    assertEquals("Hello world!Hello world!", writer.getContent());
  }

  @Test
  public void writeThenCloseThenWriteToWriter() {
    writer.write("Hello world!");
    writer.close();
    writer.write("Hello world!");

    assertEquals("Hello world!", writer.getContent());
  }

  @Test
  public void closeThenWriteToWriter() {
    writer.close();
    writer.write("Hello world!");

    assertEquals("", writer.getContent());
  }
}