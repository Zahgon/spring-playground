/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.todomvc.web;

import de.odrotbohm.spring.hotwire.webmvc.Hotwire;
import de.odrotbohm.spring.hotwire.webmvc.TurboStreams;
import example.todomvc.Todo;
import example.todomvc.web.TemplateModel.TodoForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
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

@Profile("turbo")
@Controller
@RequestMapping(path = "/", produces = Hotwire.TURBO_STREAM_VALUE)
@RequiredArgsConstructor
class TurboTodoController {

    private final TemplateModel template;

    @GetMapping
    TurboStreams turboIndex(Model model, @RequestParam Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * An optimized variant of {@link #createTodo(TodoItemFormData)}. We explicitly bind to the
     * {@value Hotwire.TURBO_STREAM_VALUE} media type to distinguish Hotwire requests. We then perform the normal insert
     * and then return two {@link TurboStreams} for the parts of the page that need updates by rendering the corresponding
     * fragments of the template.
     *
     * @param form
     * @param model
     * @return
     */
    @PostMapping
    TurboStreams turboCreateTodo(@Valid @ModelAttribute("form") TodoForm form, @RequestParam Optional<String> filter, Model model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @PutMapping("/{todo}/toggle")
    TurboStreams turboToggleCompletion(@PathVariable Todo todo, @RequestParam Optional<String> filter, Model model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @DeleteMapping("/{todo}")
    TurboStreams turboDeleteTodo(@PathVariable Todo todo, @RequestParam Optional<String> filter, Model model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @DeleteMapping("/completed")
    TurboStreams turboDeleteCompletedTodos(@RequestParam Optional<String> filter, Model model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
