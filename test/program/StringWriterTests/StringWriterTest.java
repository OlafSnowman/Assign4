package program.StringWriterTests;

import program.StringWriter;
import program.WriterTestSuite;

public class StringWriterTest extends WriterTestSuite {
  @Override
  protected StringWriter createWriter() {
    return new StringWriter();
  }
}
