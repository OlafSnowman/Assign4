package program;

import org.junit.jupiter.api.Test;
import program.operations.DuplicateRemoverOperation;
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
  public void UpperCaseThenStupidRemoverModification() throws IOException {
    Writer writer = new FileWriter(UpperCaseOperation::toUpperCase, StupidRemoverOperation::removeStupid);
    writer.write("stupid");

    assertEquals("STUPID", writer.getContent());
  }

  @Test
  public void lowerCaseThenStupidRemoverThenUpperCase() throws IOException {
    Writer writer = new StringWriter(LowerCaseOperation::toLowerCase, StupidRemoverOperation::removeStupid,
        UpperCaseOperation::toUpperCase);
    writer.write("StuPID");

    assertEquals("S*****", writer.getContent());
  }

  @Test
  public void upperCaseThenStupidRemoverThenLowerCase() throws IOException {
    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, StupidRemoverOperation::removeStupid,
        LowerCaseOperation::toLowerCase);
    writer.write("StuPID");

    assertEquals("stupid", writer.getContent());
  }

  @Test
  public void upperCaseThenDuplicateRemover() throws IOException {
    Writer writer = new FileWriter(UpperCaseOperation::toUpperCase, DuplicateRemoverOperation::removeDuplicates);
    writer.write("hello HellO");

    assertEquals("HELLO", writer.getContent());
  }
  @Test
  public void lowerCaseThenDuplicateRemover() throws IOException {
    Writer writer = new StringWriter(LowerCaseOperation::toLowerCase, DuplicateRemoverOperation::removeDuplicates);
    writer.write("hello HellO");

    assertEquals("hello", writer.getContent());
  }

  @Test
  public void stupidRemoverThenDuplicateRemoverThenUpperCase() throws IOException {
    Writer writer = new FileWriter(StupidRemoverOperation::removeStupid, DuplicateRemoverOperation::removeDuplicates,
        UpperCaseOperation::toUpperCase);
    writer.write("stupid stupid stupid");

    assertEquals("S*****", writer.getContent());
  }

  @Test
  public void lowerCaseThenDuplicateRemoverThenStupidRemoverThenUpperCase() throws IOException {
    Writer writer = new StringWriter(LowerCaseOperation::toLowerCase, DuplicateRemoverOperation::removeDuplicates,
        StupidRemoverOperation::removeStupid, UpperCaseOperation::toUpperCase);
    writer.write("sTUpid stUPId StupiD");

    assertEquals("S*****", writer.getContent());
  }

}
