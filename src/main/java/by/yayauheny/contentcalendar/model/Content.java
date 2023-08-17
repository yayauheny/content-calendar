package by.yayauheny.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        Status status,
        @NotNull
        Type contentType,
        @PastOrPresent
        LocalDateTime createdAt,
        @PastOrPresent
        LocalDateTime updatedAt,
        @NotBlank
        String url

) {

}
