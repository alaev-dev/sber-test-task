package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.entity.Status;

import java.time.Instant;
import java.util.UUID;

@Data
public class MessageDto {

    @NotNull
    private UUID id;

    @NotNull
    private String content;

    @NotNull
    private Instant timestamp;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Status status;

    @JsonCreator
    public MessageDto(@JsonProperty("id") UUID id,
                      @JsonProperty("content") String content,
                      @JsonProperty("timestamp")
                      @JsonFormat(
                              shape = JsonFormat.Shape.STRING,
                              pattern = "yyyy-MM-dd'T'HH:mm:ss",
                              timezone = "UTC")
                      Instant timestamp,
                      @JsonProperty(value = "status", access = JsonProperty.Access.READ_ONLY)
                          Status status) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
    }
}
