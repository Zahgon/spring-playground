package example.todomvc.web;

import example.todomvc.Todo;
import example.todomvc.web.TemplateModel.TodoForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Spring MVC controller to render a traditional Thymeleaf template. Assumes full HTTP requests and rendering.
 *
 * @author Oliver Drotbohm
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
class TodoController {

    private final TemplateModel template;

    @GetMapping
    String index(@RequestParam Optional<String> filter, Model model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @PostMapping
    String createTodo(@Valid @ModelAttribute("form") TodoForm form) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @PutMapping("/{id}/toggle")
    String toggleCompletion(@PathVariable("id") Todo todo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @DeleteMapping("/{todo}")
    String deleteTodo(@PathVariable Todo todo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @DeleteMapping("/completed")
    String deleteCompletedTodos(@RequestParam Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
