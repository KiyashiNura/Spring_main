package com.kyashinura.Spring_main;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Random;
import java.util.Timer;

@SpringBootApplication
@RestController
public class SpringMainApplication {
	double a = 0;

	public static void main(String[] args) {
		SpringApplication.run(SpringMainApplication.class, args);
	}
	@RequestMapping("/")
	String hello(){
		return "Hi!";
	}
	@GetMapping(
		value = "/photo", produces = MediaType.IMAGE_JPEG_VALUE
	)
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
		Resource resource = new ClassPathResource("static/image.jpg");
		/*System.out.println(resource.getFile().exists());*/
		return resource.getInputStream().readAllBytes();
	}

	@RequestMapping("/gaussian")
	public String func(){
		Random r = new Random();
		return String.valueOf(r.nextGaussian());
	}

	@RequestMapping("/gaussian_elapsed")
	public String elapsedTime(){
		Random r = new Random();
		long start = System.nanoTime();
		a+=0.5;
		double g = r.nextGaussian();
		while (g < a){
			g = r.nextGaussian();
		}
		long end = System.nanoTime();
		return String.valueOf(end - start);
	}
}
