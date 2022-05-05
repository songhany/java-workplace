package advance.fileIO.jackson.home;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: Main [file path]");
      return;
    }

    UdacisearchClient client =
        new UdacisearchClient(
            "CatFacts LLC",
            17,
            8000,
            5,
            Instant.now(),
            Duration.ofDays(180),
            ZoneId.of("America/Los_Angeles"),
            "555 Meowmers Ln, Riverside, CA 92501");

    Path outputPath = Path.of(args[0]);

    // TODO: Write the "client" variable to the "outputPath", using a
    //       com.fasterxml.jackson.databind.ObjectMapper to serialize it into JSON. You will have to
    //       register the com.fasterxml.jackson.datatype.jsr310.JavaTimeModule with the ObjectMapper
    //       in order for it to work with the java.time fields in UdacisearchClient.
    //
    //       Next, read the JSON back and deserialize it using a ObjectInputStream.
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.writeValue(Files.newBufferedWriter(outputPath), client);

    System.out.println("Wrote to " + outputPath.toAbsolutePath().toString());

    UdacisearchClient deserialized =
            objectMapper.readValue(Files.newBufferedReader(outputPath), UdacisearchClient.class);
    System.out.println("Deserialized " + deserialized);
  }
}