package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
}
