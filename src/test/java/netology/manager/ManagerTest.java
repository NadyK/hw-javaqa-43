package netology.manager;

import netology.domain.Issue;
import netology.repository.Repository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Repository repository = new Repository();
    private final Manager manager = new Manager(repository);

    Issue first = new Issue(1, "Mark", "rt", "Alex", true, "Добавлены ссылки",new HashSet<>());

    Issue second = new Issue(2, "Mark", "yu", "Linda", false, "Исправлено",new HashSet<>());
    Issue third = new Issue(3, "Jack", "yu", "Alex", true, "Добавлено обновление",new HashSet<>() );
    Issue forth = new Issue(4, "JacK", "rt", "Linda", true,"Удалены картинки",new HashSet<>());

    @Test
    void add() {
    }

    @Test
    void searchByAuthorAndLabel() {
    }

    @Test
    void searchByAuthor() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        first.getTags().add("re");
        assertEquals(List.of(first, second), manager.searchByAuthor("Mark"));
    }


    @Test
    void searchByLabel() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        first.getTags().add("re");
        assertEquals(List.of(first, forth), manager.searchByLabel("rt"));
    }

    @Test
    void searchByAssignee() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        first.getTags().add("re");
        assertEquals(List.of(first, third), manager.searchByAssignee("Alex"));
    }
}