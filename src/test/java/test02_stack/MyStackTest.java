package test02_stack;

import Structure02_Stack.IStack;
import Structure02_Stack.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStackTest {
    @Test
    public void basic() {
        IStack<Integer> given = new MyStack<>();
        // 0 ~ 49 까지 값 추가
        for(int i = 0; i < 50; i++) {
            given.push(i);
            // 삽입 후 가장 상위 값 확인
            assertEquals(given.peek(), i);
            // 사이즈 증가 확인
            assertEquals(given.size(), i+1);
        }
        for (int i = 49; i > -1; i--){
            // 가장 상위 부터 갑 삭제 및 출력 49 -> 0 확인
            assertEquals(given.pop(), i);
            // 사이즈 감소 확인
            assertEquals(given.size(), i);
        }
    }
}
