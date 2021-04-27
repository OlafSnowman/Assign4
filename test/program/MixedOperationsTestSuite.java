package program;

import org.junit.jupiter.api.Test;
import program.operations.LowerCaseOperation;
import program.operations.StupidRemoverOperation;
import program.operations.UpperCaseOperation;

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

  @Test
  public void stupidRemoveAndLowerCaseModification() throws IOException {
    Writer writer = new StringWriter(LowerCaseOperation::toLowerCase, StupidRemoverOperation::removeStupid);
    writer.write("STUPID");

    assertEquals("s*****", writer.getContent());
  }

  @Test
  public void stupidRemoveAndUpperCaseModification() throws IOException {
    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, StupidRemoverOperation::removeStupid);
    writer.write("stupid");

    assertEquals("STUPID", writer.getContent());
  }
}
