package exam.paperContent.domain.model.paper;

import java.util.Optional;

public interface PaperRepository {
    Optional<Paper> find(PaperId paperId);

    void save(Paper paper);

    PaperId nextPaperId();
}
