package program;

public class StringWriter implements Writer {
  private StringBuilder contents = new StringBuilder();
  private boolean closed = false;

  @Override
  public void write(String text) {
    if(!closed) {
      contents.append(text);
    }
  }

  @Override
  public void close() {
    closed = true;
  }

  @Override
  public String getContent() {
    return contents.toString();
  }
}
