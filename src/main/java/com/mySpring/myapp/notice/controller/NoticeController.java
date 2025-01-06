package com.mySpring.myapp.notice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mySpring.myapp.notice.service.NoticeService;
import com.mySpring.myapp.member.vo.MemberVO;

@Controller("noticeController")
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 공지사항 목록
    @RequestMapping(value = "/listNotices.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView listNotices(HttpServletRequest request) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("noticesList", noticeService.listNotices());
        return mav;
    }

    // 공지사항 작성 화면
    @RequestMapping(value = "/writeForm.do", method = RequestMethod.GET)
    public ModelAndView writeForm(HttpServletRequest request) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        return new ModelAndView(viewName);
    }

    // 공지사항 작성
    @RequestMapping(value = "/addNotice.do", method = RequestMethod.POST)
    public ModelAndView addNotice(@RequestParam Map<String, Object> noticeMap, HttpSession session) throws Exception {
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        // 작성자 ID 추가 및 운영자 권한 확인
        if (memberVO == null || !"systemOperator".equalsIgnoreCase(memberVO.getRole())) {
            return new ModelAndView("redirect:/notice/listNotices.do")
                    .addObject("errorMessage", "운영자 권한이 필요합니다.");
        }

        // DB 컬럼명에 맞게 작성자 ID 추가
        noticeMap.put("userid", memberVO.getId());

        try {
            noticeService.addNewNotice(noticeMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/notice/listNotices.do")
                    .addObject("errorMessage", "공지사항 등록 중 오류가 발생했습니다.");
        }

        return new ModelAndView("redirect:/notice/listNotices.do");
    }

    // 공지사항 상세 보기
    @RequestMapping(value = "/viewNotice.do", method = RequestMethod.GET)
    public ModelAndView viewNotice(@RequestParam("noticeno") int noticeNo, HttpServletRequest request) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("notice", noticeService.viewNotice(noticeNo));
        return mav;
    }

    // 공지사항 수정
    @RequestMapping(value = "/editNotice.do", method = RequestMethod.POST)
    public ModelAndView editNotice(@RequestParam Map<String, Object> noticeMap) throws Exception {
        try {
            noticeService.modNotice(noticeMap);
            return new ModelAndView("redirect:/notice/listNotices.do");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/notice/listNotices.do")
                    .addObject("errorMessage", "공지사항 수정 중 오류가 발생했습니다.");
        }
    }

    // 공지사항 삭제
    @RequestMapping(value = "/deleteNotice.do", method = RequestMethod.POST)
    public ModelAndView deleteNotice(@RequestParam("noticeno") int noticeNo, HttpSession session) throws Exception {
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        // 운영자 권한 확인
        if (memberVO == null || !"systemOperator".equalsIgnoreCase(memberVO.getRole())) {
            return new ModelAndView("redirect:/notice/listNotices.do")
                    .addObject("errorMessage", "운영자 권한이 필요합니다.");
        }

        try {
            noticeService.removeNotice(noticeNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/notice/listNotices.do")
                    .addObject("errorMessage", "공지사항 삭제 중 오류가 발생했습니다.");
        }

        return new ModelAndView("redirect:/notice/listNotices.do");
    }
}
