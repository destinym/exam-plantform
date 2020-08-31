package exam.paperContent.infrastructure.paper;

import exam.paperContent.domain.model.paper.Paper;
import exam.paperContent.domain.model.paper.PaperId;
import exam.paperContent.domain.model.paper.PaperRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PaperRepositoryImpl implements PaperRepository {
    List<Paper> papers = new ArrayList<>();

    @Override
    public Optional<Paper> find(PaperId paperId) {
        return papers.stream()
                .filter(paper -> Objects.equals(paperId, paper.getPaperId()))
                .findAny();
    }

    @Override
    public void save(Paper paper) {
        Optional<Paper> optionalPaper = find((paper.getPaperId()));
        if (optionalPaper.isPresent()) {
            papers.remove(optionalPaper.get());
        }
        papers.add(paper);
    }

    @Override
    public PaperId nextPaperId() {
        return null;
    }
}
