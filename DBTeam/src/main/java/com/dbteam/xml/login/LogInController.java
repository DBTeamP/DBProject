package com.dbteam.xml.login;

import com.dbteam.xml.login.LogInService;
import com.dbteam.common.dtopackage.UsersDTO;
//import com.dbteam.xml.finddog.PrintResult;
import com.dbteam.xml.login.PrintResult;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LogInController {

    private final LogInService logInService;
    private final PrintResult printResult;

    public LogInController(){
        logInService = new LogInService();
        printResult = new PrintResult();
    }

    // 회원가입 메서드
    public void registId(Map<String, String> parameter) {
        String userName = parameter.get("userName");
        String userId = parameter.get("userId");
        String userPhone = parameter.get("userPhone");
        int regionNum = Integer.parseInt(parameter.get("regionNum"));

        // 아이디가 이미 존재하는지 확인
        if (logInService.isUserIdExists(userId)) {
            // 이미 존재하는 아이디일 경우, 오류 메시지 출력
            System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
        } else {
            // 아이디가 존재하지 않을 경우, 회원가입 진행
            UsersDTO users = new UsersDTO();
            users.setUserName(userName);
            users.setUserId(userId);
            users.setUserPhone(userPhone);
            users.setRegionNum(regionNum);

            if (logInService.insertUser(users)) {
                printResult.printSuccessMessage("insert");
            }
        }
    }


    public String lonInAdmin(Map<String, Object> parameter) {
        String userId = (String)parameter.get("userId");
        String rights = "";

        UsersDTO searchAdminId = logInService.isAdminUser(userId);

        if(searchAdminId != null){
            System.out.println("관리자 로그인에 성공하였습니다.");
            rights = "Y";

            parameter.put("userNum", searchAdminId.getUserNum());
            return rights;
        }else{
            System.out.println("잘못 입력하였습니다.");
            return rights;
        }
    }

    public String logInUser(Map<String, Object> parameter) {
        String userId = (String)parameter.get("userId");
        String rights = "";
        UsersDTO searchUserId = logInService.isUser(userId);

        if(searchUserId != null){
            System.out.println("로그인에 성공하였습니다.");
            rights = "N";
            parameter.put("userNum", searchUserId.getUserNum());
            return rights;
        } else{
            System.out.println("잘못 입력하였습니다.");
            return rights;
        }
//        try {
//            if ("N".equals(searchUserId.get(0).getAdminRights())) {
//                System.out.println("로그인에 성공하였습니다.");
//                return rights;
//            } else {
//                System.out.println("잘못 입력하였습니다.");
//                rights = "";
//                return rights;
//            }
//        } catch(IndexOutOfBoundsException e){
//            System.out.println("잘못 입력하였습니다.");
//            rights = "";
//            return rights;
//        }
    }

}