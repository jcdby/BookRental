package kr.ac.ajou.lazybones.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(DataConfig.class)
@ComponentScan("kr.ac.ajou.lazybones")
public class RootConfig {

}
