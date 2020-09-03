package exam.paperContent.infrastructure.quiz;

import exam.paperContent.domain.model.quiz.BlankQuiz;
import exam.paperContent.domain.model.quiz.BlankQuizId;
import exam.paperContent.domain.model.quiz.BlankQuizRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    public List<BlankQuiz> getAll() {
        return blankQuizzes.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<BlankQuiz> find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream().filter(blankQuiz -> blankQuiz.getBlankQuizId().equals(blankQuizId)).findFirst();
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.add(blankQuiz);
    }

}
