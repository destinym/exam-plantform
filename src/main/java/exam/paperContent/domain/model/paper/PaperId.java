package exam.paperContent.domain.model.paper;


import exam.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class PaperId implements ValueObject<PaperId> {
    private String id;
    public String nextId() {
        //todo
        return id;
    }
}

