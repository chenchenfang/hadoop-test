package com.fang7.java.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

@Data
@Slf4j
@NoArgsConstructor
public class TestLombok {
    @NonNull
    private String name;

    @SneakyThrows
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        log.error("我来啦");
        TestLombok testLombok = new TestLombok();
        testLombok.setName(null);
        @Cleanup FileInputStream fileInputStream = new FileInputStream(new File(new URI("")));

    }
}
