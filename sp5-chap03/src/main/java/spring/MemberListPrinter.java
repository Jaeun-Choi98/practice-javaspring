package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    @Qualifier("printer")
    private MemberPrinter printer;

    public void printAll(){
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> printer.print(member));
    }

}
