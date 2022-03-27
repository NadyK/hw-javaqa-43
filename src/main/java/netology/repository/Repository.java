package netology.repository;
import netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class Repository {
    public Collection<Issue> issues= new ArrayList<>();

    public void save (Issue issue){
        issues.add(issue);
    }
    public Collection<Issue>findAll(){
        return this.issues;
    }
    public void removeById(int id) {
        issues.removeIf(el ->el.getId()==id);
    }
    public void saveAll (Collection<? extends Issue>issues) {
        this.issues.addAll(issues);
    }
    public void removeAll (Collection<? extends Issue>issues) {
        this.issues.removeAll(issues);
    }

}
