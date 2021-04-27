package program.FileWriterTests;

import program.FileWriter;
import program.UpperCaseOperation;
import program.UpperCaseOperationTestSuite;
import program.Writer;

import java.io.IOException;

public class FileWriterUpperCaseOperationTest extends UpperCaseOperationTestSuite {
  @Override
  protected Writer createWriterWithUpperCaseOperation() throws IOException {
    return new FileWriter(UpperCaseOperation::toUpperCase);
  }
}
