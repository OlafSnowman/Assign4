package program.FileWriterTests;

import program.DuplicateRemoverOperationTestSuite;
import program.FileWriter;
import program.Writer;
import program.operations.DuplicateRemoverOperation;

import java.io.IOException;

public class FileWriterDuplicateRemoverOperationTest extends DuplicateRemoverOperationTestSuite {
  @Override
  protected Writer createWriter() throws IOException {
    return new FileWriter(DuplicateRemoverOperation::removeDuplicates);
  }
}
