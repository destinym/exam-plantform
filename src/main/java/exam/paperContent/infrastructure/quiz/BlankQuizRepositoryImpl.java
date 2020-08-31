package exam.paperContent.infrastructure.quiz;

import exam.paperContent.domain.model.quiz.BlankQuiz;
import exam.paperContent.domain.model.quiz.BlankQuizId;
import exam.paperContent.domain.model.quiz.BlankQuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BlankQuizRepositoryImpl implements BlankQuizRepository {
    List<BlankQuiz> blankQuizzes = new ArrayList<>();

    @Override
    public Optional<BlankQuiz> find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream()
                .filter(blankQuiz -> Objects.equals(blankQuizId, blankQuiz.getBlankQuizId()))
                .findAny();
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        Optional<BlankQuiz> optionalBlankQuiz = find((blankQuiz.getBlankQuizId()));
        if (optionalBlankQuiz.isPresent()) {
            blankQuizzes.remove(optionalBlankQuiz.get());
        }
        blankQuizzes.add(blankQuiz);

    }

    @Override
    public BlankQuizId nextBlankQuizId() {
        return null;
    }
}
