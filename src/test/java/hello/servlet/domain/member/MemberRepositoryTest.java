package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("userA", 20);

        //when

        Member member1 = memberRepository.save(member);
        //then
        Member findedMember = memberRepository.findById(member1.getId());
        assertThat(member).isEqualTo(findedMember);
        //assertThat(member1).isSameAs(member);
    }
    @Test
    void findAll(){
        //given
        Member userA = new Member("userA", 19);
        Member userB = new Member("userB", 39);
        //when
        memberRepository.save(userA);
        memberRepository.save(userB);

        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}
