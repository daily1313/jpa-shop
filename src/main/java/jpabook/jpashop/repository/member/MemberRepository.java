package jpabook.jpashop.repository.member;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpabook.jpashop.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    private final EntityManager em;
    //스프링부트가 EntityManager 주입
    //@PersistenceContext 어노테이션이 있을 경우
    //Cmd + Shift + T (Test 코드)
    public void save(Member member) {
        em.persist(member);
        // 영속성 컨텍스트에 멤버 객체를 올린다.
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {

        // SQL : 테이블 대상으로 쿼리
        // JPQL : 엔티티 객체를 대상으로 쿼리
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();

    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name" , name)
                .getResultList();
    }




}
