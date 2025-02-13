package ntnu.stud.no.compiler.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompilerController {

  @CrossOrigin(origins = "http://localhost:5173/")
  @PostMapping("/run")
  public String run(@RequestBody String code) {
    return "Ok!";
  }
}
