package jpabook.jpashop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;
    //스프링부트가 EntityManager 주입
    //@PersistenceContext 어노테이션이 있을 경우

    //Cmd + Shift + T (Test 코드)
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
