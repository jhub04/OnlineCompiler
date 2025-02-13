package ntnu.stud.no.compiler.controller;

import org.slf4j.LoggerFactory;
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
  public String run(@RequestBody String code) {
    logger.info("User POST request received with input: {}", code);
    return "Ok!";
  }
}
