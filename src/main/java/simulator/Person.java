package simulator;

import lombok.*;
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
