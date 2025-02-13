package ntnu.stud.no.compiler.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
      BufferedWriter writer = new BufferedWriter(new FileWriter("Code.java", false));
      writer.write(code);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok(code);
  }
}
