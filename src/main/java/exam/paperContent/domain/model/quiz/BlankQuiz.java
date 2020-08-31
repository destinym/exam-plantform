package exam.paperContent.domain.model.quiz;

import exam.Entity;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String topic;
    private List<String> answers;

    public BlankQuiz(BlankQuizId blankQuizId, String topic, List<String> answers) {
        this.blankQuizId = blankQuizId;
        this.topic = topic;
        this.answers = answers;
    }

    public BlankQuiz build(BlankQuizId blankQuizId,String topic, List<String> answers) {
        if (StringUtils.isBlank(topic)){
                try {
                    throw new IllegalTopicException();
                } catch (IllegalTopicException e) {
                    e.printStackTrace();
                    return null;
                }
        }
        if (CollectionUtils.isEmpty(answers)){
                try {
                    throw new IllegalAnswersCountException();
                } catch (IllegalAnswersCountException e) {
                    e.printStackTrace();
                    return null;
                }
        }
        return  new BlankQuiz(blankQuizId, topic,answers);
    }


}
