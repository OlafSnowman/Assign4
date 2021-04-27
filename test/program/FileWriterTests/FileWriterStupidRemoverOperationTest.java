package program.FileWriterTests;

import program.FileWriter;
import program.StupidRemoverOperationTestSuite;
import program.Writer;
import program.operations.StupidRemoverOperation;

import java.io.IOException;

public class FileWriterStupidRemoverOperationTest extends StupidRemoverOperationTestSuite {
  @Override
  protected Writer createWriter() throws IOException {
    return new FileWriter(StupidRemoverOperation::removeStupid);
  }
}
