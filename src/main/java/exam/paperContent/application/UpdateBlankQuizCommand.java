package exam.paperContent.application;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateBlankQuizCommand {
    private String topic;
    private List<String> ansewers;
}
