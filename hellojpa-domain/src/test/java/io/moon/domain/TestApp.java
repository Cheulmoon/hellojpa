/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 이 클래스를 설정하지 않으면
 * {@link org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest @DataJpaTest}를 사용하는 테스트에서는
 * <pre>
 *  {@code @ContextConfiguration(classes = App.class)}
 * </pre>
 *
 * {@link org.springframework.boot.test.context.SpringBootTest @SpringBootTest}를 사용하는 테스트에서는
 * <pre>
 *  {@code @SpringBootTest(classes = App.class)}
 * </pre>
 *
 * 즉 {@link org.springframework.boot.autoconfigure.SpringBootApplication @SpringBootApplication}을 사용하는 클래스를 명시해야 한다.
 */
@SpringBootApplication(scanBasePackages = {"io.moon"})
public class TestApp {
}
