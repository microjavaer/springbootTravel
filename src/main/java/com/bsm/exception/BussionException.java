package com.bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BussionException extends RuntimeException {
    private CustomizeCode customizeCode;
}
