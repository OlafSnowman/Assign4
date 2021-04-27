package program.StringWriterTests;

import program.LowerCaseOperation;
import program.LowerCaseOperationTestSuite;
import program.StringWriter;
import program.Writer;

public class StringWriterLowerCaseOperationTest extends LowerCaseOperationTestSuite {
  @Override
  public Writer createWriterWithLowerCaseOperation() {
    return new StringWriter(LowerCaseOperation::toLowerCase);
  }
}
