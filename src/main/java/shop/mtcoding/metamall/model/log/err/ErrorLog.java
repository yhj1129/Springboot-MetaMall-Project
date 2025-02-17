package shop.mtcoding.metamall.model.log.err;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter // DTO 만들면 삭제해야됨
@Getter
@Table(name = "error_log_tb")
@Entity
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String msg;
    private Long userId;
    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;  필요 없을 듯

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    } 필요 없을 듯

    @Builder
    public ErrorLog(Long id, String msg, Long userId, LocalDateTime createdAt) {
        this.id = id;
        this.msg = msg;
        this.userId = userId;
        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    }
}
