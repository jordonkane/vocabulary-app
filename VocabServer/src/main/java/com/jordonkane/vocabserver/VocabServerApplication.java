package com.jordonkane.vocabserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jordonkane.vocabserver")
@EnableAutoConfiguration
public class VocabServerApplication {

	public static void main(String[] args) { SpringApplication.run(VocabServerApplication.class, args); }

}
