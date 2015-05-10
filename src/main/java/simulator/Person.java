package simulator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Person {
    private int x;
    private int y;
    private Status status;
}
