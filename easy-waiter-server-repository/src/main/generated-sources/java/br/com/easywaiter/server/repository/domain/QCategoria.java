package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoria is a Querydsl query type for Categoria
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoria extends EntityPathBase<Categoria> {

    private static final long serialVersionUID = 1450013025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoria categoria = new QCategoria("categoria");

    public final NumberPath<Long> codigoEstabelecimento = createNumber("codigoEstabelecimento", Long.class);

    public final QEstabelecimento estabelecimento;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final ListPath<Produto, QProduto> produtos = this.<Produto, QProduto>createList("produtos", Produto.class, QProduto.class, PathInits.DIRECT2);

    public QCategoria(String variable) {
        this(Categoria.class, forVariable(variable), INITS);
    }

    public QCategoria(Path<? extends Categoria> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoria(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoria(PathMetadata metadata, PathInits inits) {
        this(Categoria.class, metadata, inits);
    }

    public QCategoria(Class<? extends Categoria> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estabelecimento = inits.isInitialized("estabelecimento") ? new QEstabelecimento(forProperty("estabelecimento"), inits.get("estabelecimento")) : null;
    }

}

