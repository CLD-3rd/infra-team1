package com.team1.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.entity.OttAccount;
import com.team1.entity.OttPlatform;
import com.team1.entity.Rental;
import com.team1.entity.UserAccount;
import com.team1.repository.OttAccountRepository;
import com.team1.repository.OttPlatformRepository;
import com.team1.repository.RentalRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OttPlatformController {

    private final OttPlatformRepository ottPlatformRepository;
    private final OttAccountRepository ottAccountRepository;
    private final RentalRepository rentalRepository;

    // 공통으로 보여주는 OTT 리스트 페이지
    @GetMapping({"/ott", "/ott/{userno}"})
    public String showOttList(@PathVariable(required = false) Long userno,
                              HttpSession session,
                              HttpServletRequest request, // 현재 요청 경로 확인용
                              Model model) {
        UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");

        List<OttPlatform> ottList = ottPlatformRepository.findAll();
        model.addAttribute("ottList", ottList);

        if (loginUser != null) {
            model.addAttribute("userno", loginUser.getUserNo());
        }

        // 로그인 안 되어 있을 때만 redirect 경로 저장
        if (loginUser == null) {
            session.setAttribute("redirectAfterLogin", request.getRequestURI());
        }

        return "ott-list";
    }



    // 구독 처리 (로그인된 사용자만 요청 가능)
    @PostMapping("/ott/{userno}/subscribe")
    public String subscribeOtt(@PathVariable Long userno,
                               @RequestParam("ottId") Long ottId,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        UserAccount user = (UserAccount) session.getAttribute("loginUser");

        if (user == null || !user.getUserNo().equals(userno)) {
            return "redirect:/login";
        }

        Optional<OttAccount> optionalOacc = ottAccountRepository.findFirstByOttNo_OttNo(ottId);
        if (optionalOacc.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "사용 가능한 계정이 없습니다.");
            return "redirect:/ott/" + userno;
        }

        OttAccount ottAccount = optionalOacc.get();

        if (rentalRepository.findByUserAndOttAccount(user, ottAccount).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "이미 구독된 계정입니다.");
            return "redirect:/rent/" + user.getUserNo();
        }

        Rental rental = Rental.builder()
                .user(user)
                .ottAccount(ottAccount)
                .rstart(new Timestamp(System.currentTimeMillis()))
                .rexpiry(Date.valueOf(LocalDate.now().plusMonths(1)))
                .build();

        rentalRepository.save(rental);
        redirectAttributes.addFlashAttribute("subscribeSuccess", true);
        return "redirect:/rent/" + user.getUserNo();
    }
}
