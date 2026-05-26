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

import example.todomvc.Todo;
import example.todomvc.Todos;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Helper component to prepare {@link Model} instances to render a template. Also converts form data into domain
 * objects.
 *
 * @author Oliver Drotbohm
 */
@Component
@RequiredArgsConstructor
class TemplateModel {

    private static final Sort DEFAULT_SORT = TypedSort.sort(Todo.class).by(Todo::getCreated);

    private final Todos todos;

    void prepareForm(Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Todo save(TodoForm form) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Todo save(Todo todo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Todo save(Todo todo, Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void saveForm(TodoForm form, Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void delete(Todo todo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void delete(Todo todo, Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void deleteCompletedTodos() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void prepareTodos(Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void prepareReferenceData(Todo todo, Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void prepareReferenceData(Model model, Optional<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Streamable<Todo> todos(Optional<String> filter) {
        // Needed due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=576093
        var defaulted = filter.orElse("");
        return switch(defaulted) {
            case "active" ->
                todos.findByCompleted(false, DEFAULT_SORT);
            case "completed" ->
                todos.findByCompleted(true, DEFAULT_SORT);
            default ->
                todos.findAll(DEFAULT_SORT);
        };
    }

    public record TodoForm(@NotBlank String title) {

        Todo toEntity() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public record TodoDto(UUID id, String title, boolean completed) {
    }
}
