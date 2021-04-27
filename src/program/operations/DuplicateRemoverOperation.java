package program.operations;

import java.util.StringJoiner;

public interface DuplicateRemoverOperation {
  static String removeDuplicates(String text) {
    String[] words = text.split(" ");

    int index = 1;
    for(int i = 1; i < words.length; i++) {
      if(!words[index - 1].equals(words[i])) {
        words[index++] = words[i];
      }
    }

    StringJoiner joiner = new StringJoiner(" ");
    for(int i = 0; i < index; i++) {
      joiner.add(words[i]);
    }

    return joiner.toString();
  }
}
