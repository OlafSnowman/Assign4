package program.StringWriterTests;

import program.StringWriter;
import program.operations.UpperCaseOperation;
import program.UpperCaseOperationTestSuite;
import program.Writer;

public class StringWriterUpperCaseOperationTest extends UpperCaseOperationTestSuite {
  @Override
  protected Writer createWriterWithUpperCaseOperation() {
    return new StringWriter(UpperCaseOperation::toUpperCase);
  }
}
