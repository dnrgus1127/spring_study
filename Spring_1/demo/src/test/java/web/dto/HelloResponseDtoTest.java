package web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.web.dto.HelloResponseDto;

public class HelloResponseDtoTest {
    
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //assertThat 테스트 검증 메소드 검증 대상을 인자로 받는다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
