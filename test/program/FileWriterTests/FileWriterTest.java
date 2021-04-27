package program.FileWriterTests;

import program.FileWriter;
import program.Writer;
import program.WriterTestSuite;

import java.io.IOException;

public class FileWriterTest extends WriterTestSuite {
  @Override
  public Writer createWriter() throws IOException {
    return new FileWriter();
  }
}
