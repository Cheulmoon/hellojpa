package io.moon.domain.product.entity;

import static org.assertj.core.api.Assertions.*;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest(properties = {"spring.config.location=classpath:/application-domain.yml"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductTest {

    @Autowired
    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void init() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    @DisplayName("상품 생성 성공테스트")
    public void shouldCreateProduct() {

        // given
        Product product = Product.builder()
                .name("뜨거운 냉장고")
                .build();

        // when
        em.persist(product);

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(QProduct.product.id.eq(product.getId()));

        Product savedProduct = queryFactory.selectFrom(QProduct.product)
                .where(builder)
                .fetchOne();

        // then
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct).isEqualTo(product);
    }

}

