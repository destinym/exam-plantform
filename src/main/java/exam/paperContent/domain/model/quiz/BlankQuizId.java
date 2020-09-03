package exam.paperContent.domain.model.quiz;

import java.util.UUID;

public class BlankQuizId {
    private String id;

    public BlankQuizId(String id) {
        this.id = id;
    }

    public static BlankQuizId nextId() {
        String uuid = UUID.randomUUID().toString();
        return new BlankQuizId(uuid);
    }

    public static BlankQuizId from(String blankQuizId) {
        return new BlankQuizId(blankQuizId);
    }
}
