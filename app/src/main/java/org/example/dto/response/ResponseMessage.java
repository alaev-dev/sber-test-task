package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.entity.Status;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Data
public class ResponseMessage {

    private UUID messageId;
    private Status status;
    private Instant processedAt;

    @JsonCreator
    public ResponseMessage(@JsonProperty("id") UUID messageId,
                           @JsonProperty("processedAt")
                           @JsonFormat(
                                   shape = JsonFormat.Shape.STRING,
                                   pattern = "yyyy-MM-dd'T'HH:mm:ss",
                                   timezone = "UTC")
                           Instant processedAt,
                           @JsonProperty("status") Status status) {
        this.messageId = messageId;
        this.processedAt = processedAt;
        this.status = status;
    }
}
