package org.example.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class StringUtilT {

    public static boolean isEmpty(String str) {
        return (Objects.equals(null,str) || str.length()==0||str.matches("\\s")) ? true : false;
    }
}
