package viewer;
//여러가지 뷰어를 모아서
//특정 사항마다 해당 뷰어의 필요한 메소드를 실행해 주고
//메뉴 출력등을 담당하는 메인뷰어 클래스

import java.util.Scanner;

import model.TeacherDTO;
import util.ScannerUtil;

public class MainViewer {

    //뷰어를 private필드로 한다,
    private StudentViewer studentViewer;
    private TeacherViewer teacherViewer;
    private EvaluationViewer evaluationViewer;
    
    //입력을 처리할 Scanner 객체
    private Scanner scanner;
    
    //학생 목록 전체 출력에 사용될 옵션 상수
    private final int VALUE_ALL =1;
   //성적 미입력 학생 목록 출력에 사용될 옵션 상수
    private final int VALUE_NO_INPUT =2;
    
    //1.각 viewer을 초기화하는 생성자
    public MainViewer() {
        studentViewer = new StudentViewer();
        teacherViewer = new TeacherViewer();
        evaluationViewer = new EvaluationViewer(studentViewer);
        scanner = new Scanner(System.in);
        
    }
    
    //2.인덱스 화면을 출력하는 메소드
    public void showIndex() {
        while(true) {
            String message = new String("1.로그인 2.회원가입 3.종료");
            int userChoice = ScannerUtil.nextInt(scanner, message,1,3);
            message = new String("1.교사 2.학생 3.뒤로");
            if(userChoice ==1) {
                userChoice= ScannerUtil.nextInt(scanner, message,1,3);
                if(userChoice ==1) {
                    //teacherViewer.logIn() 실행
                    int teacherGroup = teacherViewer.logIn();
                    if(teacherGroup != -1) {
                        //교사용 메인 화면 보여주기.
                        showTeacherMenu(teacherGroup);
                    }
                }else if(userChoice ==2) {
                    if(studentViewer.logIn()) {
                        //학생용 메인 화면 보여주기
                        showStudentMenu();
                        //메인 화면 메소드 종료 후에는
                        //studentViewer.logOut() 실행해서 로그인 객체 초기화
                        studentViewer.logOut();
                    }
                    
                }
            }else if(userChoice ==2) {
                
                userChoice = ScannerUtil.nextInt(scanner, message,1,3);
                if(userChoice ==1) {
                    //teacherViewer.register()실행
                }else if(userChoice ==2) {
                    studentViewer.register();
                }
            }else if(userChoice ==3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
    
    private void showStudentMenu() {
        while(true) {
            String message = new String("1.학생 목록보기 2.담임 선생님 평가 보기 3.종료");
            int userChoice = ScannerUtil.nextInt(scanner, message);
            
            if(userChoice ==1) {
                //studentViewer의 printAll을 실행하되
                //지금은 studentViewer의 StudentDTO 객체 logIn이 null이 아니므로
                //아무값이나 파라미터로 넘겨주면 된다.
                studentViewer.printList(0, 0);
            }else if(userChoice ==2) {
                //evaluationViewer의 담임 선생님 평가보기 메소드 실행
                TeacherDTO t = teacherViewer.selectOneByGroup(studentViewer.selectGroup());
                evaluationViewer.printList(t);
            }else if(userChoice ==3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
    
    private void showTeacherMenu(int group) {
        while(true) {
            String message = new String("1.반 전체 학생 보기 2.반 학생중 성적 미입력 학생보기 3. 자기평가보기 4.종료");
            int userChoice = ScannerUtil.nextInt(scanner, message,1,4);
            
            if(userChoice ==1) {
                //studentViewer의 printList을 실행하되,
                //printList의 경우, 파라미터로 group과 출력할 내용을 선택해주어야하는데
                //지금은 전체보기 이므로 private final int VALUE_ALL =1;
                //이 출력할 내용의 옵션 값이다.
                //group은 파라미터로 넘어온 group을 사용하면 된다.
                studentViewer.printList(group, VALUE_ALL);
            }else if(userChoice == 2) {
                //studentViwer의 printList의
                //group, VALUE_NO_INPUT으로 실행해준다.
                studentViewer.printList(group, VALUE_NO_INPUT);
                
            }else if(userChoice == 3) {
                //evaluationViewer의 평가보기를 실행한다.
                TeacherDTO t = teacherViewer.selectOneByGroup(group);
                evaluationViewer.printList(t);
            }else if(userChoice ==4) {
                System.out.println("인덱스 화면으로 돌아간다.");
                break;
            }
        }
    }
}
