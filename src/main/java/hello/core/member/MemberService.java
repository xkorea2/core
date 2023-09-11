package hello.core.member;

public interface MemberService {

    void join(Member member);   //가입

    Member findMember(Long memberID);   //조회
}
