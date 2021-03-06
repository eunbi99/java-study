package day0305;
/*검증 (Validation)
 * 검증이란, 사용자가 입력한 데이터가 올바른 데이터인지 확인하는 과정을 검증이라고한다.
 * 데이터를 검증하는 것은 여러가지 방법이 있지만
 * 우리는 두가지 방법을 통해 검증을 체험하게 될것이다.
 */
import java.util.Scanner;
public class GradeChecker02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        
        System.out.printf("점수를 입력해주세요 : ");
        int num = scanner.nextInt();
        
        System.out.println("--------------------");
        System.out.println("    값 검증 안된 버전          ");
        System.out.println("--------------------");
        
        if(num>=90) {
            System.out.println("A");
        }else if(num>=80) {
            System.out.println("B");
        }else if(num >=70) {
            System.out.println("C");
        }else if(num>=60) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
        
        System.out.println("---------------------------");
        System.out.println("    1. 조건식에 정확한 범위 버전        ");
        System.out.println("---------------------------");
        /*첫번째 검증 방법은
         * 우리가 조건식에 해당 결과가 나오는 조건들을 정확하게 다 잡아주는 방법이다.
         * 이 방법은 올바른 값의 범위가 연속적이지 않을 때, 좋은 방법이다.
         */
        
        
        if(num >=90 && num <= 100) {
            System.out.println("A");
        }else if(num >=80 && num <90) {
            System.out.println("B");
        }else if(num >= 70 && num <70) {
            System.out.println("C");
        }else if(num >= 60 && num <70) {
            System.out.println("D");
        }else if(num >= 0 && num <60) {
            System.out.println("F");
        }else {
            System.out.println("잘못 입력하셨습니다.");
        }
        
        
        System.out.println("---------------------------");
        System.out.println("     2. 올바른 범위 선체크 버전         ");
        System.out.println("---------------------------");
        
        /* 값이 얼마일때 얼마를 실행하라는 것은 범위가 좁지만
         * 이 값이 올바른 값인지 자체를 물어볼 때에는
         * 범위가 넓고 연속적인 경우가 있다.
         * 이때에는 해당 범위에 속할 때에만 코드를 진행시키고
         * 아닐때에는 경고메시지만 출력하는 방법을 사용가능하다.
         */
        
        if(num >=0 && num <=100) {
            /*올바른 점수의 범위에 속하는 점수이므로
             * if- else 진행
             */
            if(num>=90) {
                System.out.println("A");
            }else if(num>=80) {
                System.out.println("B");
            }else if(num >=70) {
                System.out.println("C");
            }else if(num>=60) {
                System.out.println("D");
            }else {
                System.out.println("F");
            }
            
        }else {
            System.out.println("잘못된 점수입니다.");
        }
        
        scanner.close();
    }

}
