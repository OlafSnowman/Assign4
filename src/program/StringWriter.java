package program;

import java.util.function.Function;

public class StringWriter extends Writer {
  private StringBuilder contents = new StringBuilder();

  @SafeVarargs
  public StringWriter(Function<String, String>... modifiers) {
    super(modifiers);
  }

  @Override
  void writeContent(String text) {
    contents.append(text);
  }

  @Override
  public String getContent() {
    return contents.toString();
  }
}
