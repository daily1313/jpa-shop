package jpabook.jpashop.domain.item;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import jpabook.jpashop.domain.category.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 단일 테이블 전략 -> 모든 자식 엔티티가 부모 엔티티와 함께 한 테이블에 모두 넣음
@DiscriminatorColumn(name = "dtype")
// 싱글 테이블 전략 -> 구분 컬럼 필수
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "Item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();


}
