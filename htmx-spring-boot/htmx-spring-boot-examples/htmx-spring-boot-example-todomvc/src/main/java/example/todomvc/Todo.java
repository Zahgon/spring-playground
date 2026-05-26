package example.todomvc;

import java.time.Instant;
import java.util.UUID;
import org.springframework.data.annotation.Id;

public class Todo {

    @Id
    private UUID id;

    private String title;

    private boolean completed;

    private Instant created;

    public Todo(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.completed = false;
        this.created = Instant.now();
    }

    public UUID getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTitle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Instant getCreated() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Todo toggleCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
