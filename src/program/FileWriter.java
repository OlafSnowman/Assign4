package program;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class FileWriter extends Writer {
  java.io.BufferedWriter writer;

  @SafeVarargs
  public FileWriter(Function<String, String>... modifiers) throws IOException {
    super(modifiers);
    writer = new BufferedWriter(new java.io.FileWriter("content.txt"));
  }

  @Override
  void writeContent(String text) throws IOException {
    writer.write(text);
    writer.flush();
  }

  @Override
  public String getContent() throws IOException {
    return Files.readString(Path.of("content.txt"));
  }
}
