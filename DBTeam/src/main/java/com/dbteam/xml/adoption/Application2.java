package com.dbteam.xml.adoption;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {

    /*테스트*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AdoptionController adoptionController = new AdoptionController();

        do {
            System.out.println("================= 입양 일지 ==================");
            System.out.println("1. 입양일지 추가 ");
            System.out.println("2. 입양일지 삭제 ");
            System.out.println("9. 프로그램 종료");
            System.out.println("============================================");
            System.out.println("수행할 관리 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: adoptionController.registAdoption(inputAdoption()); break;
                case 2: adoptionController.deleteAdoption(inputAdoptionCode()); break;
                case 9: System.out.println("입양 일지 프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 관리 번호입니다."); break;

            }
        } while (true);

    }

    //추가
    private static Map<String, String> inputAdoption() {
        Scanner sc = new Scanner(System.in);
        System.out.print("일지 제목을 입력하세요 : ");
        String adoptionName = sc.nextLine();
        System.out.print("일지 내용을 입력하세요 : ");
        String adoptionTxt = sc.nextLine();
        System.out.print("유저 번호를 입력하세요 : ");
        String userNum = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("adoptionName", adoptionName);
        parameter.put("adoptionTxt", adoptionTxt);
        parameter.put("userNum", userNum);

        return parameter;
    }

    //삭제
    private static Map<String,String> inputAdoptionCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입양일지 번호를 입력하세요 : ");
        String adoptionNum = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("adoptionNum", adoptionNum);

        return parameter;

    }







}


/*public class AdoptionDTO {
    private int adoptionNum;
    private String adoptionName;
    private String adoptionTxt;
    private int userNum;
    private int regionNum;

*/