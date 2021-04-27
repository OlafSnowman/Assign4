package program.StringWriterTests;

import program.StringWriter;
import program.StupidRemoverOperationTestSuite;
import program.Writer;
import program.operations.StupidRemoverOperation;

public class StringWriterStupidRemoverOperationTest extends StupidRemoverOperationTestSuite {
  @Override
  protected Writer createWriter() {
    return new StringWriter(StupidRemoverOperation::removeStupid);
  }
}
