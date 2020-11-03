package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduto is a Querydsl query type for Produto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduto extends EntityPathBase<Produto> {

    private static final long serialVersionUID = 709399207L;

    public static final QProduto produto = new QProduto("produto");

    public final BooleanPath ativo = createBoolean("ativo");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<byte[], Byte> imagem = createArray("imagem", byte[].class);

    public final StringPath nome = createString("nome");

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QProduto(String variable) {
        super(Produto.class, forVariable(variable));
    }

    public QProduto(Path<? extends Produto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduto(PathMetadata metadata) {
        super(Produto.class, metadata);
    }

}

