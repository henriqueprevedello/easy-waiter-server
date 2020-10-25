package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerfil is a Querydsl query type for Perfil
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerfil extends EntityPathBase<Perfil> {

    private static final long serialVersionUID = -1928693666L;

    public static final QPerfil perfil = new QPerfil("perfil");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public QPerfil(String variable) {
        super(Perfil.class, forVariable(variable));
    }

    public QPerfil(Path<? extends Perfil> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerfil(PathMetadata metadata) {
        super(Perfil.class, metadata);
    }

}

