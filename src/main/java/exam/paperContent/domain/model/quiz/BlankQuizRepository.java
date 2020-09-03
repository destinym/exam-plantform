package exam.paperContent.domain.model.quiz;

import java.util.Optional;

public interface BlankQuizRepository {
    Optional<BlankQuiz> find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

}
