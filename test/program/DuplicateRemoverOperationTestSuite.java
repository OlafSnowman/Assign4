package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class DuplicateRemoverOperationTestSuite {
  Writer writer;

  protected abstract Writer createWriter() throws IOException;

  @BeforeEach
  public void init() throws IOException {
    writer = createWriter();
  }

  @Test
  public void removeDuplicate() throws IOException {
    writer.write("hello hello");

    assertEquals(writer.getContent(), "hello");
  }

  @Test
  public void removeMultipleDuplicates() throws IOException {
    writer.write("hello hello world world");

    assertEquals(writer.getContent(), "hello world");
  }

  @Test
  public void removeDuplicatesInBetweenMessage() throws IOException {
    writer.write("hello hello there world world");

    assertEquals(writer.getContent(), "hello there world");
  }

  @Test
  public void removeDuplicatesInWithNonConsecutiveDuplicates() throws IOException {
    writer.write("hello there hello hello there world world life life is good is good good");

    assertEquals(writer.getContent(), "hello there hello there world life is good is good");
  }

  @Test
  public void removeDuplicatesIsCaseSensitive() throws IOException {
    writer.write("hello HELLo there TheRE");

    assertEquals(writer.getContent(), "hello HELLo there TheRE");
  }
}
