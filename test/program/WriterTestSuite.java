package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class WriterTestSuite {
  protected abstract Writer createWriter() throws IOException;

  Writer writer;

  @BeforeEach
  public void init() throws IOException {
    writer = createWriter();
  }

  @Test
  public void canary() {
    assertTrue(true);
  }

  @Test
  public void writeNothingToStringWriter() throws IOException {
    assertEquals("", writer.getContent());
  }


  @Test
  public void writeStringToWriter() throws IOException {
    writer.write("Hello world!");

    assertEquals("Hello world!", writer.getContent());
  }

  @Test
  public void writeStringTwiceToWriter() throws IOException {
    writer.write("Hello world!");
    writer.write("Hello world!");

    assertEquals("Hello world!Hello world!", writer.getContent());
  }

  @Test
  public void writeThenCloseThenWriteToWriter() throws IOException {
    writer.write("Hello world!");
    writer.close();
    writer.write("Hello world!");

    assertEquals("Hello world!", writer.getContent());
  }

  @Test
  public void closeThenWriteToWriter() throws IOException {
    writer.close();
    writer.write("Hello world!");

    assertEquals("", writer.getContent());
  }
}
