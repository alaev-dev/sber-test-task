package org.example.entity;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Status {
    PROCESSED, FAILED;
}
