package controllers;

import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("Question") String question,
                        @RequestParam("Answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("Question") String question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping("/getAll")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/getRandom")
    public Question getRandom() {
        return javaQuestionService.getRandomQuestion();
    }
}
