package dat3.repositories;

import dat3.cars.entity.Member;
import dat3.cars.repository.MemberRepository;
import dat3.security.dto.UserWithRolesRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    static String memb1;

    static String memb2;

    //Tests
    @BeforeAll
    public static void setupData(@Autowired MemberRepository memberRepository) {
        //Creation of UserWithRolesRequests containing the body attributes inherited from the super
        UserWithRolesRequest c1bodyOfSuper = new UserWithRolesRequest("Johnny", "secretCode", "john@mail.com");
        UserWithRolesRequest c2bodyOfSuper = new UserWithRolesRequest("CoolGuy", "noLooking", "adam@mail.com");

        //Creation of objects
        Member m1 = new Member(c1bodyOfSuper,"John", "Johnson", "road street", "Cityzin", 1000);
        Member m2 = new Member(c2bodyOfSuper, "Adam", "Adamson", "streetster", "Openhagen", 1500);

        //Saving objects to local database (H2)
        memberRepository.save(m1);
        memberRepository.save(m2);

        memb1 = m1.getUsername();
        memb2 = m2.getUsername();
    }

    @Test
    public void testFindByUsername() {

        Member found1 = memberRepository.findMemberByUsername(memb1);
        Member found2 = memberRepository.findMemberByUsername(memb2);

        assertEquals(memb1, found1.getUsername());
        assertEquals(memb2, found2.getUsername());

        assertEquals("Johnny", found1.getUsername());
        assertEquals("CoolGuy", found2.getUsername());
    }


}
