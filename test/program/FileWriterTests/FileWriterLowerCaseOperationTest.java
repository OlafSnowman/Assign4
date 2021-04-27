package program.FileWriterTests;

import program.FileWriter;
import program.LowerCaseOperation;
import program.LowerCaseOperationTestSuite;
import program.Writer;

import java.io.IOException;

public class FileWriterLowerCaseOperationTest extends LowerCaseOperationTestSuite {

  @Override
  protected Writer createWriterWithLowerCaseOperation() throws IOException {
    return new FileWriter(LowerCaseOperation::toLowerCase);
  }
}
