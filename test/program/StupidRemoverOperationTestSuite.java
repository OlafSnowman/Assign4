package program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class StupidRemoverOperationTestSuite {
  Writer writer;

  protected abstract Writer createWriter() throws IOException;

  @BeforeEach
  public void init() throws IOException {
    writer = createWriter();
  }

  @Test
  public void removeStupidFromWriter() throws IOException {
    writer.write("stupid");

    assertEquals("s*****", writer.getContent());
  }

  @Test
  public void removeStupidTwiceFromWriter() throws IOException {
    writer.write("stupid stupid");

    assertEquals("s***** s*****", writer.getContent());
  }

  @Test
  public void removeStupidFromSentence() throws IOException {
    writer.write("Ashley is stupid");

    assertEquals("Ashley is s*****", writer.getContent());
  }

  @Test
  public void removeStupidIsCaseSensitive() throws IOException {
    writer.write("STUPID StUpid stupid");

    assertEquals("STUPID StUpid s*****", writer.getContent());
  }
}
