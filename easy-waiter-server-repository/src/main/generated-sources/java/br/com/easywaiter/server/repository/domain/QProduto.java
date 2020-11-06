package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduto is a Querydsl query type for Produto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduto extends EntityPathBase<Produto> {

    private static final long serialVersionUID = 709399207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduto produto = new QProduto("produto");

    public final BooleanPath ativo = createBoolean("ativo");

    public final QCategoria categoria;

    public final NumberPath<Long> codigoCategoria = createNumber("codigoCategoria", Long.class);

    public final NumberPath<Long> codigoEstabelecimento = createNumber("codigoEstabelecimento", Long.class);

    public final StringPath descricao = createString("descricao");

    public final QEstabelecimento estabelecimento;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<byte[], Byte> imagem = createArray("imagem", byte[].class);

    public final StringPath nome = createString("nome");

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QProduto(String variable) {
        this(Produto.class, forVariable(variable), INITS);
    }

    public QProduto(Path<? extends Produto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduto(PathMetadata metadata, PathInits inits) {
        this(Produto.class, metadata, inits);
    }

    public QProduto(Class<? extends Produto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoria = inits.isInitialized("categoria") ? new QCategoria(forProperty("categoria"), inits.get("categoria")) : null;
        this.estabelecimento = inits.isInitialized("estabelecimento") ? new QEstabelecimento(forProperty("estabelecimento"), inits.get("estabelecimento")) : null;
    }

}

