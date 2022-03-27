package netology.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Issue implements Comparable<Issue>{
    private int id;
    private String author;
    private String label;
    private String assignee;

 //   public boolean isOpen() {
 //       return open;
 //   }

  //  public void setOpen(boolean open) {
  //      this.open = open;
 //   }

    private boolean open;
    private String content;
    private Set<String> tags;

    @Override
    public int compareTo(Issue o) {
        return this.id - o.id;
    }



