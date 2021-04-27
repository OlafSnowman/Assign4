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

    assertEquals(writer.getContent(), "s*****");
  }

  @Test
  public void removeStupidTwiceFromWriter() throws IOException {
    writer.write("stupid stupid");

    assertEquals(writer.getContent(), "s***** s*****");
  }

  @Test
  public void removeStupidFromSentence() throws IOException {
    writer.write("Ashley is stupid");

    assertEquals(writer.getContent(), "Ashley is s*****");
  }

  @Test
  public void removeStupidIsCaseSensitive() throws IOException {
    writer.write("STUPID StUpid stupid");

    assertEquals(writer.getContent(), "STUPID StUpid s*****");
  }
}
