package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@DiscriminatorValue("B")
@Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
