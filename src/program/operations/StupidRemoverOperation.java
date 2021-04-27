package program.operations;

public interface StupidRemoverOperation {
  static String removeStupid(String text) {
    return text.replaceAll("stupid", "s*****");
  }
}
