package com.br.domain.service.spec;

import com.br.domain.model.Orgao;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class TemplateSpec {

    @And({
            @Spec(path = "nome", spec = Like.class)
    })
    public interface OrgaoSpec extends Specification<Orgao> {}

}
