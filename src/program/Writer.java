package program;

public interface Writer {
  void write(String text);

  void close();

  String getContent();
}
