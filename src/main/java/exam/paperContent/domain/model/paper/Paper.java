package exam.paperContent.domain.model.paper;

import exam.Entity;
import exam.paperContent.domain.model.quiz.BlankQuiz;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
public class Paper implements Entity<Paper> {
    private PaperId paperId;
    private List<BlankQuiz> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    private Paper(PaperId paperId, List<BlankQuiz> blankQuizzes, String teacherId, LocalDateTime createTime) {
        this.paperId = paperId;
        this.blankQuizzes = blankQuizzes;
        this.teacherId = teacherId;
        this.createTime = createTime;
    }

    public static Paper assemble(PaperId paperId, List<BlankQuiz> blankQuizzes, String teacherId) {
        validateQuizzes(blankQuizzes);
        return new Paper(paperId, blankQuizzes, teacherId, LocalDateTime.now());
    }

    private static void validateQuizzes(List<BlankQuiz> blankQuizzes) {
        if (blankQuizzes.size() < 5 || blankQuizzes.size() > 20) {
            try {
                throw new IllegalQuizzesCountException(blankQuizzes.size());
            } catch (IllegalQuizzesCountException e) {
                e.printStackTrace();
            }
        }
    }

}
