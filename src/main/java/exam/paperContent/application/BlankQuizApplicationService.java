package exam.paperContent.application;

import exam.paperContent.domain.model.quiz.BlankQuiz;
import exam.paperContent.domain.model.quiz.BlankQuizId;
import exam.paperContent.domain.model.quiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId createBlankQuiz(CreateBlankQuizCommand command) {
        final BlankQuizId blankQuizId = BlankQuizId.nextId();
        final BlankQuiz blankQuiz = BlankQuiz.build(blankQuizId, command.getTopic(), command.getAnsewers());
        blankQuizRepository.save(blankQuiz);
        return blankQuizId;
    }

    public void updateBlankQuiz(String blankQuizId, UpdateBlankQuizCommand command) {
        Optional<BlankQuiz> optionalBlankQuiz = blankQuizRepository.find(BlankQuizId.from(blankQuizId));
        optionalBlankQuiz.ifPresent(blankQuiz -> {
            blankQuiz.rebuild(command.getTopic(), command.getAnsewers());
            blankQuizRepository.save(blankQuiz);
        });
    }
}
