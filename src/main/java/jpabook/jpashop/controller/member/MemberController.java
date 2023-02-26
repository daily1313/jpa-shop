package jpabook.jpashop.controller.member;

import java.util.List;
import javax.validation.Valid;
import jpabook.jpashop.controller.MemberForm;
import jpabook.jpashop.domain.member.Address;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm",new MemberForm());
        // controller -> view 로 이동할때 데이터를 실어서 넘김
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create (@Valid MemberForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        // inline함수 -> cmd + opt + N
        return "members/memberList";
    }
}
