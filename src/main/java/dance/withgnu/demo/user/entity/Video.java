package dance.withgnu.demo.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String userName;
    private String musicName;
    private Integer poseNumber;
    private Integer heart;
    private Integer view;
    private Integer poseCategoryId; // 0 for full body, 1 for half body
    private String videoUrl;
    private LocalDateTime createDate;
}
