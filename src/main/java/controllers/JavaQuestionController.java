package controllers;

import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("Question") String question,
                        @RequestParam("Answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("Question") Question question) {
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
