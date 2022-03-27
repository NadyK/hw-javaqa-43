package netology.manager;

import netology.domain.Issue;
import netology.repository.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public Collection<Issue> searchByAuthorAndLabel(String author, String label) {
        return findBy(issue -> issue.getAuthor().equalsIgnoreCase(author)
                && issue.getLabel().equalsIgnoreCase(label));
    }
    public Collection<Issue> searchByAuthor(String author) {
        return findBy(issue -> issue.getAuthor().equalsIgnoreCase(author));
    }
    public Collection<Issue> searchByLabel(String label) {
        return findBy(issue -> issue.getLabel().equalsIgnoreCase(label));
    }
    public Collection<Issue> searchByAssignee(String assignee) {
        return findBy(issue -> issue.getAssignee().equalsIgnoreCase(assignee));
    }
    public Collection<Issue> searchByOpen(boolean open) {
        return findBy(issue -> Objects.equals(issue.isOpen(), open));
    }
    private Collection<Issue> findBy(Predicate<Issue> filter) {
        Collection<Issue> allFromRepo = repository.findAll();
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (filter.test(issue)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return Arrays.asList(result) ;
    }

}
