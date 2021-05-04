package hello.hellospring.repository;

import hello.hellospring.controller.MemberRepository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Gon");

        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();
        System.out.println("result: " + (result == member));
//        Assertions.assertEquals(member, result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
        System.out.println("result id: " + result.getId() + ", member id :" + member.getId());
    }
}
