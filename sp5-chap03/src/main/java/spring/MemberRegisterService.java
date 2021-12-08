package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest reg){
        Member member = memberDao.selectByEmail(reg.getEmail());
        if(member != null){
            throw new DuplicateMemberException("dup email" + reg.getEmail());
        }
        Member newMember = new Member(
                reg.getEmail(), reg.getPassWord(), reg.getName(),
                LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
