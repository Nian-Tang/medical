package com.medical.controller;


import com.medical.entity.User;
import com.medical.service.ConsultingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 咨询表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/consulting")
public class ConsultingController {
    @Autowired
    private ConsultingService consultingService;

    /**
     * 杨俊武
     * 问诊记录
     * @param session
     * @return
     */
    @GetMapping("/selectConsulting")
    public List selectConsulting(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List list = consultingService.selectConsulting(user.getId());
        return list;
    }

}
