package exam.application;

import exam.paperContent.application.BlankQuizApplicationService;
import exam.paperContent.application.CreateBlankQuizCommand;
import exam.paperContent.application.UpdateBlankQuizCommand;
import exam.paperContent.domain.model.quiz.BlankQuiz;
import exam.paperContent.domain.model.quiz.BlankQuizId;
import exam.paperContent.domain.model.quiz.BlankQuizRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class BlankQuizApplicationServiceTest {
    private BlankQuizApplicationService blankQuizApplicationService;

    @Before
    private void init() {
        BlankQuizRepository blankQuizRepository = mock(BlankQuizRepository.class);
        blankQuizApplicationService = new BlankQuizApplicationService(blankQuizRepository);

    }

    @Test
    public void testCreateBlankQuiz() {
        CreateBlankQuizCommand createBlankQuizCommand = new CreateBlankQuizCommand();
        createBlankQuizCommand.setAnsewers(Arrays.asList("正确", "好的"));
        createBlankQuizCommand.setTopic("这个问题_是哪个_");
        BlankQuizId blankQuiz = blankQuizApplicationService.createBlankQuiz(createBlankQuizCommand);
        assertTrue(Objects.nonNull(blankQuiz));
    }

    @Test
    public void testUpdateBlankQuiz() {
        UpdateBlankQuizCommand updateBlankQuizCommand = new UpdateBlankQuizCommand();
        updateBlankQuizCommand.setAnsewers(Arrays.asList("正确", "好的"));
        updateBlankQuizCommand.setTopic("这个问题_是哪个_");
        blankQuizApplicationService.updateBlankQuiz("test", updateBlankQuizCommand);
    }
}
