package com.dbteam.xml.dog;

import com.dbteam.common.dtopackage.DogDTO;

import java.util.List;

public class PrintResult {

//    public void printDogProfileList(List<DogDTO> menuList) {
//
//    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode) {
            case "insert" : successMessage = "신규 메뉴 등록을 성공하였습니다."; break;
            case "update" : successMessage = "메뉴 수정을 성공하였습니다."; break;
            case "delete" : successMessage = "메뉴 삭제를 성공하였습니다."; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectList" : errorMessage = "전체 메뉴 목록 조회에 실패하였습니다."; break;
            case "selectOne" : errorMessage = "선택한 메뉴 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "메뉴 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "메슈 삭제에 실패하였습니다."; break;
        }

        System.out.println(errorMessage);
    }

}
