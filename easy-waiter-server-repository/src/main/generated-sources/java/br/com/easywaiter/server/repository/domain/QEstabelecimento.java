package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEstabelecimento is a Querydsl query type for Estabelecimento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEstabelecimento extends EntityPathBase<Estabelecimento> {

    private static final long serialVersionUID = -917683998L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEstabelecimento estabelecimento = new QEstabelecimento("estabelecimento");

    public final StringPath cidade = createString("cidade");

    public final StringPath cnpj = createString("cnpj");

    public final NumberPath<Long> codigoEstabelecimento = createNumber("codigoEstabelecimento", Long.class);

    public final StringPath descricao = createString("descricao");

    public final StringPath estado = createString("estado");

    public final ArrayPath<byte[], Byte> imagem = createArray("imagem", byte[].class);

    public final ListPath<Mesa, QMesa> mesas = this.<Mesa, QMesa>createList("mesas", Mesa.class, QMesa.class, PathInits.DIRECT2);

    public final StringPath numeroTelefone = createString("numeroTelefone");

    public final ListPath<Produto, QProduto> produtos = this.<Produto, QProduto>createList("produtos", Produto.class, QProduto.class, PathInits.DIRECT2);

    public final QUsuario usuario;

    public QEstabelecimento(String variable) {
        this(Estabelecimento.class, forVariable(variable), INITS);
    }

    public QEstabelecimento(Path<? extends Estabelecimento> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEstabelecimento(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEstabelecimento(PathMetadata metadata, PathInits inits) {
        this(Estabelecimento.class, metadata, inits);
    }

    public QEstabelecimento(Class<? extends Estabelecimento> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usuario = inits.isInitialized("usuario") ? new QUsuario(forProperty("usuario"), inits.get("usuario")) : null;
    }

}

