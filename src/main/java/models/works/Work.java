package models.works;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Work {
    private long workNo;
    private long userNo;
    private Status status = Status.READY;
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
