package exam.paperContent.application;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBlankQuizCommand {
    private String topic;
    private List<String> ansewers;
}
