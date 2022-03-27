package netology.repository;

import netology.domain.Issue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private Repository repo = new Repository();

    @Test
    void shouldSaveAll() {
        List<Issue>list=new ArrayList<>();
        list.add(new Issue());
        list.add(new Issue());
        repo.saveAll(list);
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void removeById() {
    }



    @Test
    void removeAll() {
    }
}