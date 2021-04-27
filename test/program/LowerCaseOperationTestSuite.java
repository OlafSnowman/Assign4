package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LowerCaseOperationTestSuite {

  Writer writer;

  protected abstract Writer createWriterWithLowerCaseOperation() throws IOException;

  @BeforeEach
  public void init() throws IOException {
    writer = createWriterWithLowerCaseOperation();
  }

  @Test
  public void writeNothingToWriter() throws IOException {
    assertEquals("", writer.getContent());
  }

  @Test
  public void writeMessageToWriter() throws IOException {
    writer.write("Hello THERE");

    assertEquals("hello there", writer.getContent());
  }

  @Test
  public void writeMultipleMessagesToWriter() throws IOException {
    writer.write("HeLLo");
    writer.write("ThERe");

    assertEquals("hellothere", writer.getContent());
  }

  @Test
  public void writeThenCloseThenWriteToWriter() throws IOException {
    writer.write("HeLLo");
    writer.close();
    writer.write("ThERE");

    assertEquals("hello", writer.getContent());
  }

  @Test
  public void closeThenWriteToWriter() throws IOException {
    writer.close();
    writer.write("HeLLO");

    assertEquals("", writer.getContent());
  }
}
