package program;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Writer {
  private boolean closed = false;
  private Function<String, String> modifier;

  @SafeVarargs
  public Writer(Function<String, String>... modifiers) {
    this.modifier = Stream.of(modifiers)
        .reduce(Function::andThen)
        .orElse(string -> string);
  }

  public void write(String text) throws IOException {
    if(!closed) {
      writeContent(modifier.apply(text));
    }
  }

  abstract void writeContent(String text) throws IOException;

  abstract String getContent() throws IOException;

  public void close() {
    closed = true;
  }
}
