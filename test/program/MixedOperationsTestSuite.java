package program;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MixedOperationsTestSuite {
  @Test
  public void lowerCaseThenUpperCaseModification() throws IOException {
    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, LowerCaseOperation::toLowerCase);
    writer.write("HeLLo TheRE");

    assertEquals("hello there", writer.getContent());
  }

  @Test
  public void upperCaseThenLowerCaseModification() throws IOException {
    Writer writer = new FileWriter(LowerCaseOperation::toLowerCase, UpperCaseOperation::toUpperCase);
    writer.write("HeLLo TheRE");

    assertEquals("HELLO THERE", writer.getContent());
  }
}
