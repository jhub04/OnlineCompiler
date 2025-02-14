package ntnu.stud.no.compiler.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class CompilerController {
  private final static Logger logger = LoggerFactory.getLogger(CompilerController.class);

  @CrossOrigin(origins = "http://localhost:5173/")
  @PostMapping("/run")
  public ResponseEntity<String> run(@RequestBody String code) {
    logger.info("User POST request received with input: {}", code);
    try {
      File javaFile = new File("Code.java");
      try (FileWriter writer = new FileWriter(javaFile)) {
        writer.write(code);
      }

      ProcessBuilder pb = new ProcessBuilder(
          "docker", "run", "--rm", "-v", javaFile.getAbsolutePath() + ":OnlineCompiler/Code.java", "java-runner"
      );
      pb.redirectErrorStream(true);
      Process process = pb.start();

      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      StringBuilder output = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append("\n");
      }
      process.waitFor();


    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok(code);
  }
}
