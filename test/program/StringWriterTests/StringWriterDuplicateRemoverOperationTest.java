package program.StringWriterTests;

import program.DuplicateRemoverOperationTestSuite;
import program.StringWriter;
import program.Writer;
import program.operations.DuplicateRemoverOperation;

public class StringWriterDuplicateRemoverOperationTest extends DuplicateRemoverOperationTestSuite {
  @Override
  protected Writer createWriter() {
    return new StringWriter(DuplicateRemoverOperation::removeDuplicates);
  }
}
